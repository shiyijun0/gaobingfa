package cn.bdqn.gaobingfa.activemq;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class Consumer {
    private Consumer consumer;
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "mytest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
    }

    public String string(HttpServletRequest request, HttpServletResponse response){
        //request.getParameterMap()
        UUID.randomUUID().toString();
        return "df";
    }
}
