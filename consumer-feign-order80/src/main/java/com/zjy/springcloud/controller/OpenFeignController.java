package com.zjy.springcloud.controller;

import com.zjy.springcloud.entities.CommonResult;
import com.zjy.springcloud.entities.Payment;
import com.zjy.springcloud.service.PaymentFeignService;
import feign.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhujunyang
 * created on 2021/8/31 10:59
 * @Version 1.0
 */
@RestController
public class OpenFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value="/consumer/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

}
