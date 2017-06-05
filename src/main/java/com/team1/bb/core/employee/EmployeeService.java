package com.team1.bb.core.employee;

import com.team1.bb.util.WebContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * EmployeeServiceBean
 */
@Service
public class EmployeeService {

    private final WebContextUtil webContextUtil;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(WebContextUtil webContextUtil, EmployeeRepository employeeRepository) {
        this.webContextUtil = webContextUtil;
        this.employeeRepository = employeeRepository;
    }

    public Boolean isAuthenticated() {
        return webContextUtil.getEmail().isPresent();
    }

    public Employee getCurrentUser() {
        String email = webContextUtil.getEmail()
                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("Employee not logged in yet."));

        return employeeRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("UsernameNotFound: '" + email + "'"));
    }

    public Optional<Employee> getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

}
