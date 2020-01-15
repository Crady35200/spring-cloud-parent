package com.crady.zuul.config;

import com.crady.zuul.filter.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :Crady
 * date :2020/1/14 17:37
 * desc :
 **/
@Configuration
public class ZuulFilterConfig {

    @Bean
    public HttpHeaderParamZuulFilter authZuulFilter(){
        return new HttpHeaderParamZuulFilter();
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
