package com.crady.zuul;

import com.crady.zuul.filter.ErrorCustomerFilter;
import com.crady.zuul.filter.PostCustomerFilter;
import com.crady.zuul.filter.PreCustomerFilter;
import com.crady.zuul.filter.RouteCustomerFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.servlet.annotation.WebFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableFeignClients
@EnableCircuitBreaker
//@WebFilter(filterName = "myFilter",urlPatterns = "/*")
public class MsGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsGatewayZuulApplication.class, args);
    }
    @Bean
    public PreCustomerFilter preZuulFilter(){
        return new PreCustomerFilter();
    }
    @Bean
    public RouteCustomerFilter routeZuulFilter(){
        return new RouteCustomerFilter();
    }
    @Bean
    public PostCustomerFilter postZuulFilter(){
        return new PostCustomerFilter();
    }
    @Bean
    public ErrorCustomerFilter errorZuulFilter(){
        return new ErrorCustomerFilter();
    }


}
