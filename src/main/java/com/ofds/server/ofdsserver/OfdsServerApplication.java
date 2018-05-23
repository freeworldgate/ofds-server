package com.ofds.server.ofdsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class OfdsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OfdsServerApplication.class, args);
    }
}
