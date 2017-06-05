package com.team1.bb.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * WebSecurityConfig
 *
 * Setups HTTP Basic Authentication and CSRF protection
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger log = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        log.info("Configuring web security");

        //Enabled http basic protection
        http.httpBasic();

        //Allow certain urls
        http.authorizeRequests()
                .antMatchers(PermitAllUrls.getUrls()).permitAll()
                .anyRequest().authenticated();

        http.logout()
            .logoutUrl("/api/logout")
            .clearAuthentication(true)
            .invalidateHttpSession(true)
            .deleteCookies("JESSIONID")
            .logoutSuccessUrl("/")
            .permitAll();

        http.csrf().disable();

        //In order to see h2 console
        http.headers()
                .frameOptions()
                .disable();
    }

}
