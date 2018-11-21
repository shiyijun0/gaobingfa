package cn.bdqn.gaobingfa.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service("producer")
public class Producer {
    // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
   // private JmsMessagingTemplate jmsTemplate;
    @Autowired
    private JmsTemplate jmsTemplate;
    // 发送消息，destination是发送到的队列，message是待发送的消息
    public void sendMessage(Destination destination, final String message){
        jmsTemplate.convertAndSend(destination, message);
    }

    @JmsListener(destination="out.queue1")
    public void consumerMessage(String text){
        System.out.println("从out.queue队列收到的回复报文2为:"+text);
    }
}
