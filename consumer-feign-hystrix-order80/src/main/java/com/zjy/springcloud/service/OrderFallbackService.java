package com.zjy.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zhujunyang
 * created on 2021/9/1 14:12
 * @Version 1.0
 */
@Component
public class OrderFallbackService implements HystrixOrderService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------payment fallback, paymentInfo_OK, /(ㄒoㄒ)/~~ ";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----------payment fallback, paymentInfo_Timeout, /(ㄒoㄒ)/~~ ";
    }
}
