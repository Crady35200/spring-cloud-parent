package com.crady.zuul.controller;

import com.crady.zuul.service.UserOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.util.HashMap;

/**
 * @author :Crady
 * date :2019/6/25 14:46
 * desc :
 **/
@Slf4j
@RestController
public class UserOrderController {
    @Autowired
    UserOrderService userOrderService;

    /**
     * 异步调用多服务，聚合
     * @param id
     * @param name
     * @return
     */
    @RequestMapping("/getUserOrder")
    public DeferredResult<HashMap<String,Object>> getUserOrder(Integer id,String name){
        Observable<HashMap<String,Object>> re =
                Observable.zip(userOrderService.getUserById(id),userOrderService.getOrderDetails(name),
                (user,orderDetails) -> {
                    HashMap<String,Object> result = new HashMap<>();
                    result.put("user",user);
                    result.put("orderDetails",orderDetails);
                    return result;
                });
        DeferredResult<HashMap<String,Object>> deferredResult = new DeferredResult<>();
        re.subscribe(new Observer<HashMap<String, Object>>() {
            @Override
            public void onCompleted() {
                log.info("完成...");
            }

            @Override
            public void onError(Throwable e) {
                log.info("出错了={}",e);
            }

            @Override
            public void onNext(HashMap<String, Object> stringObjectHashMap) {
                deferredResult.setResult(stringObjectHashMap);
            }
        });
        log.info("deferredResult={}",deferredResult);
        return deferredResult;

    }
}
