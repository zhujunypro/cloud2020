package com.zjy.springcloud.controller;



import com.zjy.springcloud.entities.CommonResult;
import com.zjy.springcloud.entities.Payment;
import com.zjy.springcloud.lb.LoaderBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author zhujunyang
 * created on 2021/8/25 16:47
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderController {

    //public static final String PAYMENT_URL="http://localhost:8001";
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoaderBalancer loaderBalancer;


    @GetMapping(value="/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+ "/payment/create", payment, CommonResult.class);

    }

    @GetMapping(value="consumer/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+ "/payment/get/"+id, CommonResult.class);
    }

    @GetMapping(value="consumer/payment/getEntity/{id}")
    public CommonResult getEntity(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> response = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if(response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        }else{
            return new CommonResult(404,"error");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size()<=0){
            return null;
        }

        ServiceInstance serviceInstance = loaderBalancer.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb", String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin", String.class);
    }
}
