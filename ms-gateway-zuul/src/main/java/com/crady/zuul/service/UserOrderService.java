package com.crady.zuul.service;

import com.crady.zuul.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

/**
 * @author :Crady
 * date :2019/6/25 14:34
 * desc :
 **/
@Service
public class UserOrderService {
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;

    public Observable<User> getUserById(Integer id){
        return Observable.create(observer -> {
            User user = userFeignClient.getUserById(id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    public Observable<String> getOrderDetails(String name){
        return Observable.create(observer ->{
           String orderDetails = orderFeignClient.getOrderDetail(name);
           observer.onNext(orderDetails);
           observer.onCompleted();
        });
    }

}
