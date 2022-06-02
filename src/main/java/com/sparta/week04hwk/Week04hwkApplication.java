package com.sparta.week04hwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week04hwkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week04hwkApplication.class, args);
    }


}
