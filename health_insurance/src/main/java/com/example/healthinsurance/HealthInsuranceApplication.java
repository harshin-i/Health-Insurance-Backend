package com.example.healthinsurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HealthInsuranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthInsuranceApplication.class, args);
    }
}
