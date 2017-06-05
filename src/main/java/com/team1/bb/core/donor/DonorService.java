package com.team1.bb.core.donor;

import com.team1.bb.core.donation.Donation;
import com.team1.bb.core.donation.DonationRepository;
import com.team1.bb.core.embeddable.Address;
import com.team1.bb.core.embeddable.CommonFields;
import com.team1.bb.core.employee.EmployeeService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by sdebnath on 4/30/17.
 */
@Service
public class DonorService {

    String accountSid = "AC9f6755a229cb883cca9ee3ee426e72c4"; // Your Account SID from www.twilio.com/user/account
    String authToken = "c73e635ef727f854e45b2553120c31fc"; // Your Auth Token from www.twilio.com/user/account
    String twilioNumber = "+15189418391";

    private final DonorRepository donorRepository;

    @Autowired
    private DonationRepository donationRepository;

    private final EmployeeService employeeService;

    @Autowired
    public DonorService(DonorRepository donorRepository, EmployeeService employeeService) {
        this.donorRepository = donorRepository;
        this.employeeService = employeeService;
    }

    public Donor addNewDonor(Donor donor){
        Long id = employeeService.getCurrentUser().getId();

        return donorRepository.save(donor
            .withCommonFields(new CommonFields()
                .withCreatedById(id)
                .withUpdatedById(id)));
    }

    public void notifyOldDonors(){
        List<Donor> eligibeDonors = verifyCanDonateAgain(getAllDonors());

        Twilio.init(accountSid, authToken);

        for (Donor donor : eligibeDonors) {
            if (donor.getCanDonateAgain()) {
                Message message = Message.creator(
                    new PhoneNumber("+1" + donor.getPhoneNumber()),  // To number
                    new PhoneNumber(twilioNumber),  // From number
                    donor.getFirstName() + ", you are eligible to donate again. We truly appreciate your donations!" // SMS body
                ).create();
            }
        }
    }

    public List<Donor> getAllDonors(){
        return StreamSupport.stream(donorRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    public List<Donor> getAllDonorsByName(String firstName, String lastName) {
        return verifyCanDonateAgain(donorRepository
            .findAllByFirstNameContainingAndLastNameContaining(firstName, lastName));
    }

    public List<Donor> getAllDonorsByDateOfBirth(int year, int month, int day) {
        return donorRepository.findAllByDateOfBirth(new LocalDate(year, month, day));
    }

    public List<Donor> getAllDonorsByAddress(Address address) {
        return donorRepository.findAllByAddress(address);
    }

    public List<Donor> verifyCanDonateAgain(List<Donor> donors) {
        LocalDate now = LocalDate.now();

        for (Donor donor : donors) {
            Donation donation = donationRepository.findFirstByDonor(donor);

            if (donation != null) {
                LocalDate lastDonated = donation.getDrawDate();

                donor.setCanDonateAgain(Days.daysBetween(lastDonated, now).getDays() >= 56);

            } else {
                donor.setCanDonateAgain(true);
            }

        }

        return donors;
    }
}
