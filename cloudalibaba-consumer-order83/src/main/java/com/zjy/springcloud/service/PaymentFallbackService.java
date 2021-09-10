package com.zjy.springcloud.service;

import com.zjy.springcloud.entities.CommonResult;
import com.zjy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

/**
 * @author zhujunyang
 * created on 2021/9/9 20:06
 * @Version 1.0
 */
@Service
public class PaymentFallbackService implements PaymentService{
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444444, "服务降级返回，fallback");
    }
}
