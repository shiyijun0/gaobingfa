package cn.bdqn.gaobingfa.rabbitmq;

import cn.bdqn.gaobingfa.entity.LockMapper;
import cn.bdqn.gaobingfa.service.LockMapperService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "redis_lock")
public class RedisReceiver {
    @Autowired
    private LockMapperService lockMapperService;
    @RabbitHandler
    public  void redis_lock(LockMapper msg){

if(msg instanceof LockMapper){
    lockMapperService.insert(msg);
}else {
    System.out.println("*****不是该类型**");
    lockMapperService.insert(msg);
}

    }
}
