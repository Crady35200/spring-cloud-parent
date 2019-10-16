package com.crady.movie.controller;

import com.crady.movie.service.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :Crady
 * date :2019/10/15 14:29
 * desc :
 **/
@Slf4j
@RestController
@RequestMapping("ribbon")
public class RibbonController {
    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("hello")
    public String hello(String msg){
        String result = userFeignClient.hello(msg);
        log.info(result);
        return result;
    }
    @GetMapping("timeOut/{timeOut}")
    public String hello(@PathVariable(value = "timeOut",required = true) Integer timeOut){
        String result = userFeignClient.timeOut(timeOut);
        log.info(result);
        return result;
    }

}
