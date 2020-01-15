package com.crady.movie.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author :Crady
 * date :2020/1/15 9:13
 * desc :拦截feign请求并把header设置到请求中，以便在下个服务中可以获取到
 **/
@Slf4j
public class HttpHeaderParamFeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        Map<String, String> attributes = RibbonFilterContextHolder.getCurrentContext().getAttributes();
        //拦截feign请求并把header设置到请求中，以便在下个服务中可以获取到
        for (Map.Entry<String,String> entry : attributes.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            template.header(key,value);
            log.info("HttpHeaderParamFeignInterceptor...header params...{}={}",key,value);
        }
    }
}
