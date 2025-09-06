package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.kafka.annotation.EnableKafka;

 
/**
 * @author Gaurav Khairnar
 * @Dates
 * @description 
 */
@EnableKafka
@SpringBootApplication(scanBasePackages = "com.test")
public class SprinbootKafkApp2 extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SprinbootKafkApp2.class, args);
    }

}