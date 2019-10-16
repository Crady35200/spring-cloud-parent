package com.crady.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableAspectJAutoProxy
public class MsProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProviderUserApplication.class, args);
    }

}
