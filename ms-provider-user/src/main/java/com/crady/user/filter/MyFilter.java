package com.crady.user.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * @author :Crady
 * date :2020/1/14 16:49
 * desc : 自定义过滤器
 **/
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      log.info("myFilter init...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("myFilter doFilter...");
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry entry :parameterMap.entrySet()){
            log.info("{}={}",entry.getKey(),entry.getValue());
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("myFilter destroy...");
    }
}
