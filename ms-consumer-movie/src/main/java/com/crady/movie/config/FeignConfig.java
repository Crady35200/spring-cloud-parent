package com.crady.movie.config;

import com.crady.movie.interceptor.HttpHeaderParamFeignInterceptor;
import com.crady.movie.interceptor.MyFeignInterceptor;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author :Crady
 * date :2020/1/14 14:46
 * desc : feign配置类
 **/
@Configuration
public class FeignConfig {

    /**
     * 配置feign日志
     * Logger.Level.NONE:不记录任何日志
     * Logger.Level.BASIC;仅记录请求方法、URL及响应码和执行时间
     * Logger.Level.HEADERS：除了记录BASIC级别的信息外，还会记录请求头和响应头的信息
     * Logger.Level.FULL：记录所有信息
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }

    /**
     * 注入feign拦截器
     * @return
     */
    @Bean
    public MyFeignInterceptor feignInterceptor(){
        return new MyFeignInterceptor();
    }

    /**
     * 注入http header参数拦截器
     * @return
     */
    @Bean
    public HttpHeaderParamFeignInterceptor headerParamFeignInterceptor(){
        return new HttpHeaderParamFeignInterceptor();
    }
}
