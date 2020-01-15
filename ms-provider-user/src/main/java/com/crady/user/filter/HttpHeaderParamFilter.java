package com.crady.user.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author :Crady
 * date :2020/1/15 11:34
 * desc :
 **/
@Slf4j
public class HttpHeaderParamFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("***************init*****************");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("***************doFilter*****************");
        HttpServletRequest hRequest = (HttpServletRequest) request;
        String token = hRequest.getHeader("token");
        log.info("HttpHeaderParamFilter...http header......token={}",token);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("**************destroy************");
    }
}
