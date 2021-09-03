package com.zjy.springcloud.controller;

import com.zjy.springcloud.entities.CommonResult;
import com.zjy.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhujunyang
 * created on 2021/8/25 16:47
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value="/consumer/payment/zk")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+ "/payment/create", payment, CommonResult.class);
    }

}
