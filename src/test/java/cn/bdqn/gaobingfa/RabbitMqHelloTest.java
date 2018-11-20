package cn.bdqn.gaobingfa;

import cn.bdqn.gaobingfa.rabbitmq.HelloSender;
import cn.bdqn.gaobingfa.rabbitmq.receiver.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private TopicSender topicSender;

    @Test
    public void send(){
        helloSender.send();
    }

    @Test
    public void sendTopic(){

        topicSender.send1();
    }



}
