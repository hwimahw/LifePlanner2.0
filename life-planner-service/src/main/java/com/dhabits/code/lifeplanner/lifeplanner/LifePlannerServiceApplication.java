package com.dhabits.code.lifeplanner.lifeplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.dhabits.code.lifeplanner.lifeplanner.db.model"})
public class LifePlannerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(LifePlannerServiceApplication.class, args);
    }

}
