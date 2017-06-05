package com.team1.bb.core.test;

import com.team1.bb.core.donation.Donation;
import com.team1.bb.core.donation.DonationRepository;
import com.team1.bb.core.donor.Donor;
import com.team1.bb.core.donor.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sdebnath on 4/30/17.
 */
@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonorRepository donorRepository;


    public List<Test> getAllUndoneTests(){
        return testRepository.findAllByPassIsNull();
    }

    public void update(Long testId, Boolean pass) {
        Test test = testRepository.findOne(testId);

        test.setPass(pass);

        if (!pass) {
           Donation donation = donationRepository.findOne(test.getDonation().getId());
           donation.withViability(false);
           donationRepository.save(donation);

           Donor donor = donorRepository.findOne(donation.getDonor().getId());
           donor.withEligibility(false);
           donorRepository.save(donor);
        }
    }
}
