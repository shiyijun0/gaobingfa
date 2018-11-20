package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.entity.LockMapper;
import cn.bdqn.gaobingfa.rabbitmq.RedisReceiver;
import cn.bdqn.gaobingfa.rabbitmq.RedisSender;
import cn.bdqn.gaobingfa.rabbitmq.fanout.FanoutSender;
import cn.bdqn.gaobingfa.rabbitmq.receiver.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitController {
    @Autowired
    private RedisReceiver redisReceiver;
    @Autowired
    private RedisSender redisSender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @RequestMapping("/lock_mapper")
    public LockMapper redis_sender(LockMapper lockMapper){

        redisSender.setAmqpTemplate(lockMapper);

        return lockMapper;
    }

    @RequestMapping("/topic")
    public String topic(String msg){

        topicSender.send();

        return msg;
    }

    @RequestMapping("/topic1")
    public String topic1(String msg){

        topicSender.send1();

        return msg;
    }

    @RequestMapping("/fanout")
    public String fanout(String msg,int count){
if(count==1){
    fanoutSender.send1(msg);
}else if(count==2){
    fanoutSender.send2(msg);
}else if(count==3){
    fanoutSender.send3(msg);
}else if(count==4){
    fanoutSender.send4(msg);
}else if(count==6){
    fanoutSender.send6(msg);
}else if(count==5){
    fanoutSender.send5(msg);
}else if(count==7){
    fanoutSender.send7(msg);
}else {
    fanoutSender.send(msg);
}

        return msg;
    }

    @RequestMapping("/topic2")
    public String topic2(String msg){

        topicSender.send2();

        return msg;
    }

}
