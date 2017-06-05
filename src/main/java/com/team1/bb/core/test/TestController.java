package com.team1.bb.core.test;

import com.team1.bb.util.annotations.ApiRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by sdebnath on 4/30/17.
 */
@ApiRestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/test/null", method = RequestMethod.GET)
    public List<Test> getNullTests(){
        return testService.getAllUndoneTests();
    }

    @RequestMapping(value = "/test/update", method = RequestMethod.GET)
    public boolean updateTest(Long testId, Boolean pass){
        testService.update(testId, pass);
        System.out.println(testId + " " + pass);
        return true;
    }
}
