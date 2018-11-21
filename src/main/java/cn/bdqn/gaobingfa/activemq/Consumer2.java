package cn.bdqn.gaobingfa.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {
    @JmsListener(destination = "mytest.queue")
    @SendTo("out.queue1")
    public String receiveQueue(String text) {
        System.out.println("Consumer收到的报文为2:"+text);
        return "return message报文2"+text;
    }
}
