package com.zjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhujunyang
 * created on 2021/9/2 20:36
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientMain3366 {
    public static void main(String[] args) {
        SpringApplication.run(ClientMain3366 .class, args);
    }
}
