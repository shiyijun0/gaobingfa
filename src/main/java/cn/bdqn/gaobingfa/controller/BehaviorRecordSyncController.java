package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import cn.bdqn.gaobingfa.redis.RedisUtil;
import cn.bdqn.gaobingfa.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/b")
public class BehaviorRecordSyncController implements BaseController<BehaviorRecordSync>{

       @Resource
       private BaseService<BehaviorRecordSync> baseService;
       @Autowired
       private RedisUtil redisUtil;

       @Resource
       private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/find")
    @ResponseBody
       @Override
    public List<BehaviorRecordSync> find() {
        return baseService.find();
    }
    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public BehaviorRecordSync insert(BehaviorRecordSync behaviorRecordSync) {
        return baseService.insert(behaviorRecordSync);
    }
    @RequestMapping("/findone")
    @ResponseBody
    @Override
    public BehaviorRecordSync findone(long id) throws EntityNotFoundException {
        BehaviorRecordSync b=null;
        try {
          b=   baseService.findone(id);
        }catch (EntityNotFoundException e){
            return  new BehaviorRecordSync();
        }
       /* if(b instanceof EntityNotFoundException){
            return new BehaviorRecordSync();
        }*/
        System.out.println("**************"+b);
        return b;
    }
    @RequestMapping("/count")
    @ResponseBody
    @Override
    public long count() {
        return baseService.count();
    }

    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int delete(long id) {
        try {
            baseService.delete(id);
        }catch (Exception e){
            return 0;
        }

        return  1;
    }
    @RequestMapping("/update")
    @ResponseBody
    @Override
    public BehaviorRecordSync update(BehaviorRecordSync behaviorRecordSync) {
        return baseService.update(behaviorRecordSync);
    }


    @RequestMapping("/redis")
    @ResponseBody
    public boolean redis_insert(BehaviorRecordSync behaviorRecordSync) {
        redisUtil.setRedisTemplate(redisTemplate);
     boolean  a=   redisUtil.set("behaviorRecordSync",behaviorRecordSync);
     boolean b=   redisUtil.set("syj","数据是奇偶偶12345");
     return b&&a;
    }

    @RequestMapping("/redis_get")
    @ResponseBody
    public Object redis_get(BehaviorRecordSync behaviorRecordSync) {
        redisUtil.setRedisTemplate(redisTemplate);
     Object a=   redisUtil.get("syj");
      Object b=  redisUtil.get("behaviorRecordSync");
        return a+"******:"+b;
    }
}
