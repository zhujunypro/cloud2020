package com.zjy.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zhujunyang
 * created on 2021/8/31 16:37
 * @Version 1.0
 */
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id){
        return "线程池： "+ Thread.currentThread().getName()+ " paymentInfo_OK, id: "+id+"\t"+"O(∩_∩)O哈哈";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_Handler", commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "5000")})
    public String paymentInfo_Timeout(Integer id){
        int timeout=3;
        //int a=10/0;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： "+ Thread.currentThread().getName()+ " paymentInfo_timeout, id: "+id+"\t"+"O(∩_∩)O哈哈, 耗时s:"+ timeout;
    }

    public String paymentInfo_Handler(Integer id){
        return "线程池： "+ Thread.currentThread().getName()+ " 系统繁忙 "+id+"/(ㄒoㄒ)/~~";
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "1000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0 ){
            throw new RuntimeException("****不能为负");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+ "\t"+"调用成功， 流水号： "+ serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负， 请稍后再试， /(ㄒoㄒ)/~~   id：" + id;
    }

}
