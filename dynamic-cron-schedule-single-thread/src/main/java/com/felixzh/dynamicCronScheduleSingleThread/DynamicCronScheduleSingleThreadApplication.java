package com.felixzh.dynamicCronScheduleSingleThread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class DynamicCronScheduleSingleThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicCronScheduleSingleThreadApplication.class, args);
    }

}
