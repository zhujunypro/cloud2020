package com.zjy.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * @author zhujunyang
 * created on 2021/8/31 13:47
 * @Version 1.0
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
