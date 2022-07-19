package com.ecabs.interview.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.ecabs.interview.model")
public class DatabaseServer {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseServer.class, args);
    }

}
