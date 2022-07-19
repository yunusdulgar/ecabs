package com.ecabs.interview.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.ecabs.interview.repository")
@EntityScan("com.ecabs.interview.model")
public class RepoConfig {

}

