package com.crady.zuul.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Enumeration;

/**
 * @author :Crady
 * date :2019/6/25 16:02
 * desc :
 **/
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    private Long startTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime = System.currentTimeMillis();
//        log.info("preHandle called ...");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle called ...");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        StringBuffer stringBuffer = new StringBuffer("请求地址：");
        stringBuffer.append(request.getRequestURL());
        Enumeration<String> params = request.getParameterNames();
        stringBuffer.append(",请求参数:");
        while(params.hasMoreElements()){
            String key = params.nextElement();
            String value = request.getParameter(key);
            stringBuffer.append(key + "=" + value + ",");
        }
        stringBuffer.append("耗时:" + (System.currentTimeMillis() - startTime) + "ms");
        log.info(stringBuffer.toString());
    }
}
