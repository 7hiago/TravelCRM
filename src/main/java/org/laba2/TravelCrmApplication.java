package org.laba2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.laba2")
public class TravelCrmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelCrmApplication.class, args);
    }
}