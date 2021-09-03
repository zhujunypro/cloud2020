package com.zjy.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zjy.springcloud.service.HystrixOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhujunyang
 * created on 2021/9/1 10:51
 * @Version 1.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallback")
public class HystrixOrderController {

    @Resource
    private HystrixOrderService hystrixOrderService;

    @GetMapping(value="/consumer/payment/hystrix/ok/{id}")

    public String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = hystrixOrderService.paymentInfo_OK(id);
        return result;
    }


    @GetMapping(value="/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand(fallbackMethod = "paymentInfo_Handler", commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        //int age = 10/0;
        String result = hystrixOrderService.paymentInfo_Timeout(id);
        return result;
    }

    public String paymentInfo_Handler(Integer id){
        return "线程池： "+ Thread.currentThread().getName()+ " 消费者系统繁忙 "+id+"/(ㄒoㄒ)/~~";
    }

    public String payment_global_fallback(){
        return "Global异常处理信息 /(ㄒoㄒ)/~~";
    }


}
