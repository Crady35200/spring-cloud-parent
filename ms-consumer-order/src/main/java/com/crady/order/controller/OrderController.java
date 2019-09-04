package com.crady.order.controller;

import com.crady.order.service.MovieFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Crady
 * date :2019/6/21 17:28
 * desc :
 **/
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    MovieFeignClient movieFeignClient;

    @GetMapping("/getOrderDetail/{name}")
    public String getOrderDetail(@PathVariable String name){
        String detail = movieFeignClient.getMovieDetail(name);
        log.info("detail={}",detail);
        return detail;
    }
}
