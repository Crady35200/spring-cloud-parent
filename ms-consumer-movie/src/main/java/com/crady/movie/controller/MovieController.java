package com.crady.movie.controller;

import com.crady.movie.po.User;
import com.crady.movie.service.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author :Crady
 * date :2019/6/20 14:55
 * desc :
 **/
@RestController
@RequestMapping("/movie")
@Slf4j
public class MovieController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id){
        User user = userFeignClient.getUserById(id);
        log.info("get user:{}",user);
        return user;
    }

    @GetMapping("/getMovieDetail/{name}")
    public String getMovieDetail(@PathVariable String name){
        String detail = "the movie " + name + " is so nice !";
        log.info(detail);
        return detail;
    }
}
