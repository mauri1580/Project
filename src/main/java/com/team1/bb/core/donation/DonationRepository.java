package com.team1.bb.core.donation;

import com.team1.bb.core.donor.Donor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sdebnath on 4/30/17.
 */
@Repository
public interface DonationRepository extends PagingAndSortingRepository<Donation, Long> {
    Donation findFirstByDonor(Donor donor);
}
