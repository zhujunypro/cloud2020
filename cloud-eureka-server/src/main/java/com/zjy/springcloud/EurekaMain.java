package com.zjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author zhujunyang
 * created on 2021/8/26 13:57
 * @Version 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMain.class, args);
    }
}
