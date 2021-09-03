package com.zjy.springcloud.service;

import com.zjy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhujunyang
 * created on 2021/8/25 13:41
 * @Version 1.0
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
