package com.crady.zuul.fallback;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author :Crady
 * date :2019/6/24 17:22
 * desc :
 **/
@Component
public class ZuulFallbackProvider implements FallbackProvider {

    @Override
    public String getRoute() {
        //也可以指定微服务  return "ms-provider-user"
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        if(cause instanceof HystrixTimeoutException){
            return response(HttpStatus.GATEWAY_TIMEOUT);
        }else{
            return response(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ClientHttpResponse response(final HttpStatus httpStatus) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return getStatusCode().value();
            }

            @Override
            public String getStatusText() throws IOException {
                return getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
//                return new ByteArrayInputStream("micro service is out of service,please try agin later".getBytes());
                return new ByteArrayInputStream("用户微服务不可用，请稍后再试".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mediaType = new MediaType("application","json", Charset.forName("UTF-8"));
//                httpHeaders.setContentType(mediaType);
                httpHeaders.setContentType(MediaType.APPLICATION_JSON);
                return httpHeaders;
            }
        };
    }
}
