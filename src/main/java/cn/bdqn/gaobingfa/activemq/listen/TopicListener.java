package cn.bdqn.gaobingfa.activemq.listen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author: elvin
 */
@Component
public class TopicListener {
 @Autowired
private Topic topic;

 private String name;
    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(String text){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + text);
    }

    @JmsListener(destination ="publish.topic" , containerFactory = "jmsListenerContainerTopic")
    public void receive1(String text){
        System.out.println("TopicListener: consumer-a 收到10000条信息: " + text);
    }
}

