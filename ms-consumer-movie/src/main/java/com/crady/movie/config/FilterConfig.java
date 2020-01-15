package com.crady.movie.config;

import com.crady.movie.filter.HttpHeaderParamFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Crady
 * date :2020/1/14 17:38
 * desc :
 **/
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        HttpHeaderParamFilter filter = new HttpHeaderParamFilter();
        filterRegistrationBean.setFilter(filter);
        List<String> patterns = new ArrayList<>();
        patterns.add("/*");
        filterRegistrationBean.setUrlPatterns(patterns);
        return filterRegistrationBean;
    }
}
