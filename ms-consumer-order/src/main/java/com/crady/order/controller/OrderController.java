package com.crady.order.controller;

import com.crady.order.service.MovieFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Crady
 * date :2019/6/21 17:28
 * desc :
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    MovieFeignClient movieFeignClient;

    @RequestMapping("/getOrderDetail/{name}")
    public String getOrderDetail(@PathVariable String name){
        String detail = movieFeignClient.getMovieDetail(name);
        return detail;
    }
}
