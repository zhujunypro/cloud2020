package com.zjy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zjy.springcloud.entities.CommonResult;
import com.zjy.springcloud.entities.Payment;
import com.zjy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhujunyang
 * created on 2021/9/8 11:04
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderNacosController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        return restTemplate.getForObject(serverUrl+"/nacos/"+id, String.class);
    }

    //@GetMapping("/consumer/fallback/{id}")
    //@SentinelResource(value = "fallback", fallback = "handlerFallback")   //处理运行异常
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", exceptionsToIgnore = {IllegalArgumentException.class})   //处理运行异常
    //@SentinelResource(value = "blockhandler", blockHandler = "blockHandler")    //处理控制台配置违规
    //@SentinelResource(value = "blockhandler", fallback = "handlerFallback", blockHandler = "blockHandler")    //优先blockHandler
    public CommonResult<Payment> paymentTempSQL(@PathVariable("id") Long id){
        if(id == 4) throw  new IllegalArgumentException("IllegalArgument,非法参数");
        return restTemplate.getForObject(serverUrl+"/paymentSQL/"+id, CommonResult.class, id);
    }

    /**
     * this function for fallback
     */
    public CommonResult handlerFallback(@PathVariable Long id, Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444, "兜底handlerfallback, exception: "+ e);
    }

    /**
     * this function for blockHandler
     */
    public CommonResult blockHandler(@PathVariable Long id , BlockException blockException){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445, "兜底handlerfallback, exception: "+ blockException.getMessage());
    }


    @Resource
    private com.zjy.springcloud.service.PaymentService paymentService;

    @GetMapping("/consumer/openfeign/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id){
        return paymentService.paymentSQL(id);
    }


}
