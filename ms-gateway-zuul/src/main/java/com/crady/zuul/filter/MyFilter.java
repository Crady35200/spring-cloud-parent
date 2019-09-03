package com.crady.zuul.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author :Crady
 * date :2019/6/25 15:35
 * desc :
 **/
@Slf4j
//开启过滤器只需开启注解
//@Component
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init ...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        StringBuffer stringBuffer = new StringBuffer("请求地址：");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURL().toString();
        stringBuffer.append(url);
        stringBuffer.append(",参数：");
        Enumeration<String> params = request.getParameterNames();
        while(params.hasMoreElements()){
            String key = params.nextElement();
            String value = request.getParameter(key);
            stringBuffer.append(key + "=" + value + ",");
        }
        log.info(stringBuffer.toString());

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        log.info("destroy ...");
    }
}
