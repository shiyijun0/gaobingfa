package cn.bdqn.gaobingfa.rabbitmq;

import cn.bdqn.gaobingfa.entity.LockMapper;
import cn.bdqn.gaobingfa.mapper.LockMapperMapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "redis_lock")
public class RedisReceiver {
    @Autowired
    private LockMapperMapper lockMapperMapper;
    @RabbitHandler
    public  void redis_lock(Object msg){

if(msg instanceof LockMapper){
    lockMapperMapper.insert((LockMapper)msg);
}else {
    System.out.println("*****不是该类型**");
}

    }
}
