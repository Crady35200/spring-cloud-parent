package com.crady.user.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.Servlet;

/**
 * @author :Crady
 * date :2019/10/16 16:25
 * desc :
 **/
@Component
@Aspect
@Slf4j
public class TimeCountAspect {

    @Pointcut("execution(* com.crady.user.controller..*(..))")
    private void pointCut(){};

    @Around("pointCut()")
    public Object timeCount(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        try {
            String url = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getRequestURL().toString();
            long start = System.currentTimeMillis();
            proceed = joinPoint.proceed();
            log.info("请求url:{},耗时:{}ms",url,System.currentTimeMillis() - start);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }
}
