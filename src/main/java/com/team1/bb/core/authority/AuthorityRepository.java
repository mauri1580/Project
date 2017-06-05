package com.team1.bb.core.authority;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by sdebnath on 4/30/17.
 */
public interface AuthorityRepository extends PagingAndSortingRepository<Authority, Long> {

    Authority findByName(String name);

}
