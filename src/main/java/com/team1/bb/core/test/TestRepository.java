package com.team1.bb.core.test;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by sdebnath on 4/30/17.
 */
public interface TestRepository extends PagingAndSortingRepository<Test, Long> {
    List<Test> findAllByPassIsNull();
}
