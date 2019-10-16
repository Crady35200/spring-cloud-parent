package com.crady.movie;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
public class MsConsumerMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsConsumerMovieApplication.class, args);
    }

    /**
     * Logger.Level.NONE:不记录任何日志
     * Logger.Level.BASIC;仅记录请求方法、URL及响应码和执行时间
     * Logger.Level.HEADERS：除了记录BASIC级别的信息外，还会记录请求头和响应头的信息
     * Logger.Level.FULL：记录所有信息
     * @return
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }

}
