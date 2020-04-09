package com.nkpdqz.spingboot_aop_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SpingbootAopDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpingbootAopDemoApplication.class, args);
    }

}
