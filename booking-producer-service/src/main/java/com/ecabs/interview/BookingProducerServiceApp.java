package com.ecabs.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookingProducerServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(BookingProducerServiceApp.class, args);
    }

}
