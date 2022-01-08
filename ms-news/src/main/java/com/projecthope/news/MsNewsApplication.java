package com.projecthope.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.projecthope.news.repository")
public class MsNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsNewsApplication.class, args);
    }

}