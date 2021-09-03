package com.zjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhujunyang
 * created on 2021/8/24 17:50
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain4 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain4.class, args);
    }
}
