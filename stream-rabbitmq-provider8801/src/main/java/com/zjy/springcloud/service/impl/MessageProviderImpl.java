package com.zjy.springcloud.service.impl;

import com.zjy.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author zhujunyang
 * created on 2021/9/6 11:27
 * @Version 1.0
 */
@EnableBinding(Source.class) //定义消息推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString() ;
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("serial: "+serial);
        return serial;
    }
}
