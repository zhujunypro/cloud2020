package com.zjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhujunyang
 * created on 2021/9/8 20:20
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelMain8841 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelMain8841.class, args);
    }
}
