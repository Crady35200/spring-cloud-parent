package com.crady.movie.filter;

import com.netflix.ribbon.Ribbon;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.ribbon.RibbonHttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author :Crady
 * date :2020/1/14 17:39
 * desc :
 **/
@Slf4j
public class HttpHeaderParamFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("HttpHeaderParamFilter...init...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("HttpHeaderParamFilter...doFilter...");
        HttpServletRequest hRequest = (HttpServletRequest) request;
        String token = hRequest.getHeader("token");
        log.info("HttpHeaderParamFilter...http header......token={}",token);
        RibbonFilterContextHolder.getCurrentContext().add("token",token);
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        log.info("HttpHeaderParamFilter...destroy...");
    }
}
