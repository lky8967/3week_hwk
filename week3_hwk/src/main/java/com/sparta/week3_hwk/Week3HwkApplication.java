package com.sparta.week3_hwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week3HwkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week3HwkApplication.class, args);
    }

}
