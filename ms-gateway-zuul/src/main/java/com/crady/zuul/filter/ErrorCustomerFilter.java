package com.crady.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author :Crady
 * date :2019/6/24 16:51
 * desc :
 **/
@Slf4j
public class ErrorCustomerFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        String url = requestContext.getRequest().getRequestURL().toString();
        String method = requestContext.getRequest().getMethod();
        log.info("请求地址：{},请求参数:{}",url,method);
        return null;
    }
}
