package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

 
/**
 * @author Gaurav Khairnar
 * @Dates
 * @description 
 */
@SpringBootApplication(scanBasePackages = "com.test")
public class WebfluxApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

}