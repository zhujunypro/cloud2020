package com.zjy.springcloud.controller;

import com.zjy.springcloud.domain.Order;
import com.zjy.springcloud.entities.CommonResult;
import com.zjy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhujunyang
 * created on 2021/9/13 10:34
 * @Version 1.0
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200, "订单创建成功");
    }
}
