package com.crady.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class MsHystrixTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsHystrixTurbineApplication.class, args);
    }

}
