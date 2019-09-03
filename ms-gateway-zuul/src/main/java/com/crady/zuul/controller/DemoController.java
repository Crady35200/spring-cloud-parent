package com.crady.zuul.controller;

import com.crady.zuul.po.User;
import com.crady.zuul.service.OrderFeignClient;
import com.crady.zuul.service.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :Crady
 * date :2019/6/24 14:43
 * desc :
 **/
@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    UserFeignClient userFeignClient;
    @Autowired
    OrderFeignClient orderFeignClient;

    @RequestMapping("/index")
    public String demo(){
        return "this is a demo zuul";
    }

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id){
        User user = userFeignClient.getUserById(id);
        log.info("user:{}",user);
        return user;
    }

    @RequestMapping("/getUserOrder")
    public Map<String,Object> getUserOrder(Integer id, String name){
        User user = userFeignClient.getUserById(id);
        String order = orderFeignClient.getOrderDetail(name);
        HashMap<String,Object> result = new HashMap<>();
        result.put("user",user);
        result.put("order",order);
        return result;
    }
}
