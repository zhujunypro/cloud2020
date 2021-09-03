package com.zjy.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * @author zhujunyang
 * created on 2021/8/25 13:45
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value="/payment/consul")
    public String paymentzk(){
        return "springcloud with consul "+serverPort+"\t"+ UUID.randomUUID().toString();
    }


}