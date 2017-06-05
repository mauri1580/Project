package com.team1.bb.core.donor;

import com.team1.bb.core.embeddable.Address;
import com.team1.bb.util.annotations.ApiRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by sdebnath on 4/30/17.
 */
@ApiRestController
public class DonorController {

    private final Logger log = LoggerFactory.getLogger(DonorController.class);

    private final DonorService donorService;

    @Autowired
    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @RequestMapping(value = "/donor/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Donor addNewDonor(@RequestBody Donor donor){
        return donorService.addNewDonor(donor);
    }

    @RequestMapping(value = "/donor/search/name", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Donor> searchDonorByName(String firstName, String lastName){
        log.info("{{}} {{}}", firstName, lastName);

        return donorService.getAllDonorsByName(firstName,lastName);
    }

    @RequestMapping(value = "/donor/notify", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void notifyDonors(){
        donorService.notifyOldDonors();
    }



    @RequestMapping(value = "/donor/search/dob")
    @ResponseStatus(HttpStatus.OK)
    public List<Donor> searchDonorByDateOfBirth(int year, int month, int day){
        return donorService.getAllDonorsByDateOfBirth(year, month, day);
    }

    @RequestMapping(value = "/donor/search/address")
    @ResponseStatus(HttpStatus.OK)
    public List<Donor> searchDonorByAddress(Address address){
        return donorService.getAllDonorsByAddress(address);
    }

}
