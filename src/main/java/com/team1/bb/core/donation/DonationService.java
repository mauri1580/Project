package com.team1.bb.core.donation;

import com.team1.bb.core.donor.Donor;
import com.team1.bb.core.donor.DonorRepository;
import com.team1.bb.core.employee.EmployeeService;
import com.team1.bb.core.test.Test;
import com.team1.bb.core.test.TestRepository;
import com.team1.bb.core.test.TestType;
import com.team1.bb.core.test.TestTypeRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by sdebnath on 4/30/17.
 */
@Service
public class DonationService {

    String accountSid = "AC9f6755a229cb883cca9ee3ee426e72c4"; // Your Account SID from www.twilio.com/user/account
    String authToken = "c73e635ef727f854e45b2553120c31fc"; // Your Auth Token from www.twilio.com/user/account
    String twilioNumber = "+15189418391";

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private TestTypeRepository testTypeRepository;

    @Autowired
    private TestRepository testRepository;

    public Donation createNewDonation(Integer donorId) {
        Donor donor = donorRepository.findOne(donorId.longValue());

        Twilio.init(accountSid, authToken);

        Message message = Message.creator(
            new PhoneNumber("+1" + donor.getPhoneNumber()),  // To number
            new PhoneNumber(twilioNumber),  // From number
            "Thanks for donation!"                    // SMS body
        ).create();

        System.out.println(message.getSid());


        return donationRepository.save(new Donation()
            .withDonor(donor)
            .withDrawDate(LocalDate.now())
            .withDrawer(employeeService.getCurrentUser())
            .withDonationCenter(employeeService.getCurrentUser().getCenter()));
    }

    public Donation createTestForDonation(Donation donation) {
        for (TestType testType : testTypeRepository.findAll()) {
            Test test = new Test()
                .withDonation(donation)
                .withType(testType);

            testRepository.save(test);
        }

        return donation;
    }
}
