package com.team1.bb.core.donor;

import com.team1.bb.core.embeddable.Address;
import org.joda.time.LocalDate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by sdebnath on 4/30/17.
 */
public interface DonorRepository extends PagingAndSortingRepository<Donor, Long> {

    List<Donor> findAllByFirstNameContainingAndLastNameContaining(String firstName, String lastName);
    List<Donor> findAllByDateOfBirth(LocalDate localDate);
    List<Donor> findAllByAddress(Address address);
    List<Donor> findAllByEligibilityEquals(Boolean eligibility);

}
