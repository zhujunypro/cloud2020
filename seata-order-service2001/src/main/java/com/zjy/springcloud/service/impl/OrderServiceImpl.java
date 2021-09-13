package com.zjy.springcloud.service.impl;

import com.zjy.springcloud.dao.OrderDao;
import com.zjy.springcloud.domain.Order;
import com.zjy.springcloud.service.AccountService;
import com.zjy.springcloud.service.OrderService;
import com.zjy.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhujunyang
 * created on 2021/9/13 10:22
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;



    @Override
    public void create(Order order) {
        log.info("开始创建订单。。。。。");
        orderDao.create(order);
        log.info("调用库存，做扣减");
        storageService.decrease(order.getProduceId(), order.getCount());
        log.info("调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("end");

        //修改订单状态
        log.info("修改订单状态开始。。。。");
        orderDao.update(order.getUserId(), 0);
        log.info("修改订单状态结束。。。。");


    }
}
