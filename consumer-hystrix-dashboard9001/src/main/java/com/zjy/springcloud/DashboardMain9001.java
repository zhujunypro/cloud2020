package com.zjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zhujunyang
 * created on 2021/9/1 17:11
 * @Version 1.0
 */
@SpringBootApplication
@EnableHystrixDashboard
public class DashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(DashboardMain9001.class, args);
    }
}
