package com.zjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhujunyang
 * created on 2021/8/31 10:40
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
public class OrderOpenFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderOpenFeignMain.class, args);
    }
}
