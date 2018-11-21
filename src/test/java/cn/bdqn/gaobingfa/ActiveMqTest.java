package cn.bdqn.gaobingfa;

import cn.bdqn.gaobingfa.activemq.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.Destination;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveMqTest {

    @Resource(name = "producer")
    private Producer producer;

    @Test
    public void contextLoads() throws InterruptedException {
        Destination destination = new ActiveMQQueue("mytest.queue");

        for(int i=0; i<100; i++){
            producer.sendMessage(destination, "myname is chhliu!!!");
        }
    }


}
