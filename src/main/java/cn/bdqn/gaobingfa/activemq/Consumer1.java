package cn.bdqn.gaobingfa.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer1 {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为1:"+text);
    }
}
