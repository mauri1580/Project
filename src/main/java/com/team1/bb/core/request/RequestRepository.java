package com.team1.bb.core.request;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by sdebnath on 4/30/17.
 */
public interface RequestRepository extends PagingAndSortingRepository<Request, Long> {
}
