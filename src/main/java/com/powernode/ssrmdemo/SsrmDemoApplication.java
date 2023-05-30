package com.powernode.ssrmdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SsrmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsrmDemoApplication.class, args);
    }

}
