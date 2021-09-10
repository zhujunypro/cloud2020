package com.zjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhujunyang
 * created on 2021/9/8 10:11
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class  NacosProviderMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9002.class, args);
    }
}
