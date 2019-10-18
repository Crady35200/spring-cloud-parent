package com.crady.user.controller;

import com.mysql.jdbc.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author :Crady
 * date :2019/10/15 14:22
 * desc :
 **/
@Slf4j
@RestController
@RequestMapping("ribbon")
public class RibbonController {

    @RequestMapping("hello")
    public String hello(@RequestParam("msg") String msg){
        if("error".equals(msg)){
            throw new IllegalArgumentException("模拟失败");
        }
        HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        String result = "hello " + msg + " from IP= " + request.getRemoteAddr() + ",PORT= " + request.getServerPort();
        log.info(result);
        return result;
    }
    @RequestMapping("timeOut")
    public String timeOut(@RequestParam(value = "timeOut",required = true) Integer timeOut){
        HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        String result = "timeOut " + timeOut + " from IP= " + request.getRemoteAddr() + ",PORT= " + request.getServerPort();
        try {
//            TimeUnit.SECONDS.sleep(timeOut);
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(result);
        return result;
    }
}
