package com.zjy.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhujunyang
 * created on 2021/9/1 10:25
 * @Version 1.0
 */
@Component
@FeignClient(value = "PROVIDER-HYSTRIX-PAYMENT", fallback = OrderFallbackService.class)
public interface HystrixOrderService {

    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id);

}
