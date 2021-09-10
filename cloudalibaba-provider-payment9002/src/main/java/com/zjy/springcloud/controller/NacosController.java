package com.zjy.springcloud.controller;

import com.zjy.springcloud.entities.CommonResult;
import com.zjy.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zhujunyang
 * created on 2021/9/8 10:13
 * @Version 1.0
 */
@RestController
public class NacosController {

    @Value("${server.port}")
    String serverPort;

    @GetMapping(value = "/nacos/{id}")
    public String echo(@PathVariable Integer id) {
        return "serverport： "+serverPort+"  Nacos Discovery " + id;
    }

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static{
        hashMap.put(1L, new Payment(1L, "1111111111111"));
        hashMap.put(2L, new Payment(2L, "2222222222222"));
        hashMap.put(3L, new Payment(3L, "3333333333333"));
    }

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult(200, "from mysql, serverPort:  "+ serverPort, payment);
        return result;
    }
}
