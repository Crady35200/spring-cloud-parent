package com.crady.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

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
        HttpServletRequest request = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        String result = "hello " + msg + " from IP= " + request.getRemoteAddr() + ",PORT= " + request.getServerPort();
        log.info(result);
        return result;
    }
}
