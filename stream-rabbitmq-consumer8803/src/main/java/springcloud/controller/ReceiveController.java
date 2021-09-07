package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author zhujunyang
 * created on 2021/9/6 14:34
 * @Version 1.0
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> mes){
        System.out.println("消费者"+serverPort+" 消息： "+mes );
    }

}
