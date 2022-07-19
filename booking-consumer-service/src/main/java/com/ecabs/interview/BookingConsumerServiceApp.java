package com.ecabs.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookingConsumerServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(BookingConsumerServiceApp.class, args);
    }
}
