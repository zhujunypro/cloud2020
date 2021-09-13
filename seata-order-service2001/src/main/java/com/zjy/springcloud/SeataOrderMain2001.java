package com.zjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhujunyang
 * created on 2021/9/10 18:27
 * @Version 1.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //取消数据源自动创建
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderMain2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMain2001.class, args);
    }
}
