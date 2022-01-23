package com.projecthope.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsNewsApplication.class, args);
    }

}