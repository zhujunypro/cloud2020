package com.zjy.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhujunyang
 * created on 2021/9/13 10:44
 * @Version 1.0
 */
@Configuration
@MapperScan("com.zjy.springcloud.alibaba.dao")
public class MybatisConfig {

}
