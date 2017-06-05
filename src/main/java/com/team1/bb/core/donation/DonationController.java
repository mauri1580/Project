package com.team1.bb.core.donation;

import com.team1.bb.util.annotations.ApiRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sdebnath on 4/30/17.
 */
@ApiRestController
public class DonationController {

    @Autowired
    private DonationService donationService;

    @RequestMapping(value = "/donation/add", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Donation searchDonorByName(Integer donorId){
        return donationService.createTestForDonation(donationService.createNewDonation(donorId));
    }
}
