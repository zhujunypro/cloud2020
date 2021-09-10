package com.zjy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhujunyang
 * created on 2021/9/8 20:22
 * @Version 1.0
 */
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        return "~~~~~~testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "~~~~~~testB";
    }

    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")    //不兜底，会显示错误页面
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2){
        return "testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "_____deal_tetsHotKey";
    }

}
