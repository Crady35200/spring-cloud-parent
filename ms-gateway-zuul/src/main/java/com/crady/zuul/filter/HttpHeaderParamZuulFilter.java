package com.crady.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.constants.ZuulConstants;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.util.StringUtils;

/**
 * @author :Crady
 * date :2020/1/14 17:25
 * desc :
 **/
@Slf4j
public class HttpHeaderParamZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        String token = context.getRequest().getHeader("token");
        log.info("AuthZuulFilter...http header...token={}",token);
        if(!StringUtils.isEmpty(token)){
            context.addZuulRequestHeader("token",token);
        }
        return null;
    }
}
