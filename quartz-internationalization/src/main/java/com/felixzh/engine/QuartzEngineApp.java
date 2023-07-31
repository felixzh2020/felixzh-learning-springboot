package com.felixzh.engine;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
//@Import(SpringUtils.class)
//@ComponentScan("{com.felixzh.engine}")
@MapperScan("{com.felixzh.engine.mapper}")
@EnableScheduling
public class QuartzEngineApp {
    public static void main(String[] args) {
        SpringApplication.run(QuartzEngineApp.class, args);
    }
}
