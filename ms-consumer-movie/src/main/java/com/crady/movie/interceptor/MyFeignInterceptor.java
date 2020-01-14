package com.crady.movie.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author :Crady
 * date :2020/1/14 14:35
 * desc :
 **/
@Slf4j
public class MyFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        log.info("MyFeignInterceptor....template={}",template);
    }
}
