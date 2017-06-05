package com.team1.bb.core.center;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sdebnath on 4/30/17.
 */
@Repository
public interface CenterRepository extends PagingAndSortingRepository<Center, Long> {
}
