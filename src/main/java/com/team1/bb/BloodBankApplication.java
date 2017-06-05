package com.team1.bb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class BloodBankApplication {

    private static final Logger log = LoggerFactory.getLogger(BloodBankApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);
	}

    @PostConstruct
    public void startup(){
        log.info("Starting {}", this.getClass().getName());
    }

    @PreDestroy
    public void shutdown(){
        log.info("Stopping {}", this.getClass().getName());
    }
}
