package com.crady.movie.service;

import com.crady.movie.po.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author :Crady
 * date :2019/6/20 15:00
 * desc :
 **/
//@FeignClient(name = "ms-provider-user",fallback = UserFeignClientFallback.class,path = "/user")
@FeignClient(name = "ms-provider-user",fallbackFactory = UserFeignClientFallbackFactory.class/*,path = "/user"*/)
public interface UserFeignClient {
    @RequestMapping(value = "user/getUserById/{id}")
    User getUserById(@PathVariable Integer id);

    @RequestMapping(value = "ribbon/hello")
    String hello(@RequestParam("msg")String msg);

    @RequestMapping(value = "ribbon/timeOut")
    String timeOut(@RequestParam(value = "timeOut",required = true) Integer timeOut);
}
@Component
class UserFeignClientFallback implements UserFeignClient{

    @Override
    public User getUserById(Integer id) {
        User user = new User();
        user.setName("Fallback-服务降级，默认用户");
        return user;
    }

    @Override
    public String hello(String msg) {
        return "服务降级";
    }

    @Override
    public String timeOut(Integer timeOut) {
        return "服务降级";
    }
}
@Component
@Slf4j
class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User getUserById(Integer id) {
                User user = new User();
                user.setName("FallbackFactory-服务降级，默认用户");
                return user;
            }

            @Override
            public String hello(String msg) {
                return "服务降级";
            }

            @Override
            public String timeOut(Integer timeOut) {
                return "服务降级";
            }
        };
    }

/*    @Override
    public UserFeignClient create(Throwable throwable) {
        log.info("Throwable throwable:{}",throwable);
        return id -> {
            User user = new User();
            user.setName("FallbackFactory-服务降级，默认用户");
            return user;
        };
    }*/
}
