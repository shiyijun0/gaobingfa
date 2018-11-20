package cn.bdqn.gaobingfa.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public  void setAmqpTemplate(Object msg){

        this.amqpTemplate.convertAndSend("redis_lock",msg);
    }
}
