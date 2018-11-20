package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.entity.LockMapper;
import cn.bdqn.gaobingfa.rabbitmq.RedisReceiver;
import cn.bdqn.gaobingfa.rabbitmq.RedisSender;
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
    @RequestMapping("/lock_mapper")
    public LockMapper redis_sender(LockMapper lockMapper){

        redisSender.setAmqpTemplate(lockMapper);

        return lockMapper;
    }

}
