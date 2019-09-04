package com.crady.user.controller;

import com.crady.user.mapper.UserMapper;
import com.crady.user.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author :Crady
 * date :2019/6/19 16:23
 * desc :
 **/
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        List<User> users = userMapper.getAllUsers();
        log.info("查询所有用户成功:{}",users);
        return users;
    }
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Integer id){
        User user = userMapper.getUserById(id);
        log.info("user={}",user);
        return user;
    }
    @PostMapping("/addUser")
    public String addUser(User user){
        log.info("删除用户...");
        int result = userMapper.insertUser(user);
        return result == 1 ? "添加用户成功" : "添加用户失败";
    }

}
