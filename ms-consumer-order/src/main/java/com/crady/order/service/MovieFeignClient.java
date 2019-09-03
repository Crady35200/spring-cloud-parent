package com.crady.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :Crady
 * date :2019/6/21 17:15
 * desc :
 **/
@FeignClient(name = "ms-consumer-movie",fallback = MovieFeignClientFallback.class,path = "/movie")
public interface MovieFeignClient {

    @RequestMapping(value = "/getMovieDetail/{name}")
    String getMovieDetail(@PathVariable String name);

}
@Component
class MovieFeignClientFallback implements MovieFeignClient {

    @Override
    public String getMovieDetail(String name) {
        return "查询寻电影【" + name + "】信息失败，服务降级";
    }
}
