package com.dsm.dsmeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DsmEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsmEurekaApplication.class, args);
    }

}

