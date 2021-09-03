package com.zjy.springcloud.service;

import com.zjy.springcloud.entities.CommonResult;
import com.zjy.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhujunyang
 * created on 2021/8/31 10:43
 * @Version 1.0
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")   //默认等待1s
public interface PaymentFeignService {

    @GetMapping(value="/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
