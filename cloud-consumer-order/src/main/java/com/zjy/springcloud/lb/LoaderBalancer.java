package com.zjy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zhujunyang
 * created on 2021/8/30 19:50
 * @Version 1.0
 */
public interface LoaderBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstanceList);
}
