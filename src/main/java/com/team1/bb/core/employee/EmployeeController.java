package com.team1.bb.core.employee;

import com.team1.bb.util.annotations.ApiRestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * UserController
 */
@ApiRestController
public class EmployeeController {

    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/authenticated", method = RequestMethod.GET)
    public ResponseEntity<Boolean> isAuthenticated(){
        return new ResponseEntity<>(employeeService.isAuthenticated(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<Employee> getUser(){
        return new ResponseEntity<>(employeeService.getCurrentUser(), HttpStatus.OK);
    }

}
