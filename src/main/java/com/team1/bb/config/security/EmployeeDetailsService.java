package com.team1.bb.config.security;

import com.team1.bb.core.employee.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementation of EmployeeDetailsService to be used during authentication
 */
@Service
public class EmployeeDetailsService implements UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(EmployeeDetailsService.class);

	private final EmployeeService employeeService;

    @Autowired
    public EmployeeDetailsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return employeeService.getEmployeeByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Employee was not found."));
	}

}
