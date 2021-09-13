package com.zjy.springcloud.service;

import com.zjy.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhujunyang
 * created on 2021/9/13 10:21
 * @Version 1.0
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
