package com.crady.zuul.service;

import com.crady.zuul.po.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author :Crady
 * date :2019/6/25 14:39
 * desc :
 **/
@FeignClient(name = "ms-consumer-order",fallback = OrderFeignClientFallback.class,path = "/order")
public interface OrderFeignClient {
    @RequestMapping("/getOrderDetail/{name}")
    public String getOrderDetail(@PathVariable String name);
}
@Component
@Slf4j
class OrderFeignClientFallback implements OrderFeignClient{

    @Override
    public String getOrderDetail(String name) {
        String error = "订单服务降级,FallbackFactory-服务降级，默认用户";
        log.info(error);
        return error;
    }
}

@Component
@Slf4j
class OrderFeignClientFallbackFactory implements FallbackFactory<OrderFeignClient> {

    @Override
    public OrderFeignClient create(Throwable throwable) {
        log.info("Throwable throwable:{}", throwable);
        log.info("订单服务降级,FallbackFactory-服务降级，默认用户");
        return null;
    }
}
