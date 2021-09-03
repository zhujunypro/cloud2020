package com.zjy.springcloud.service;

import com.zjy.springcloud.dao.PaymentDao;
import com.zjy.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhujunyang
 * created on 2021/8/25 13:42
 * @Version 1.0
 */
@Service
public class ServiceImpl implements PaymentService{

    @Resource
    PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }


    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
