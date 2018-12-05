package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import cn.bdqn.gaobingfa.exception.JdkFactory;
import cn.bdqn.gaobingfa.redis.RedisUtil;
import cn.bdqn.gaobingfa.service.BaseService;
import cn.bdqn.gaobingfa.service.BehaviorRecordSyncMapperService;
import cn.bdqn.gaobingfa.service.BehaviorRecordSyncMapperServiceImpl;
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

       @Autowired
       private BehaviorRecordSyncMapperService behaviorRecordSyncMapperService;

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


    @RequestMapping("/deleteByPrimaryKey")
    @ResponseBody
    public int deleteByPrimaryKey(Long id) {
        return behaviorRecordSyncMapperService.deleteByPrimaryKey(id);
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<BehaviorRecordSync> selectAll() {
        return behaviorRecordSyncMapperService.selectAll();
    }

    @RequestMapping("/insertSelective")
    @ResponseBody
    public int insertSelective(BehaviorRecordSync record) {
        return behaviorRecordSyncMapperService.insertSelective(record);
    }

    @RequestMapping("/selectByPrimaryKey")
    @ResponseBody
    public BehaviorRecordSync selectByPrimaryKey(Long id) {
        return behaviorRecordSyncMapperService.selectByPrimaryKey(id);
    }

    @RequestMapping("/updateByPrimaryKeySelective")
    @ResponseBody
    public int updateByPrimaryKeySelective(BehaviorRecordSync record) {
        return behaviorRecordSyncMapperService.updateByPrimaryKeySelective(record);
    }

    @RequestMapping("/guardCount")
    @ResponseBody
    public Integer guardCount(String warrant) {
        return behaviorRecordSyncMapperService.guardCount(warrant);
    }

    @RequestMapping("/insert1")
    @ResponseBody
    public int insert1(BehaviorRecordSync behaviorRecordSync) {
        return behaviorRecordSyncMapperService.insert(behaviorRecordSync);
    }
    @RequestMapping("/poxy")
    @ResponseBody
    public  List<BehaviorRecordSync> string(BehaviorRecordSync behaviorRecordSync){
       /* BehaviorRecordSyncMapperService behaviorRecordSyncMapperService1= BehaviorRecordServiceFactory.getInstance();
      return   behaviorRecordSyncMapperService1.select(behaviorRecordSync);*/

        JdkFactory jdkProxy=new JdkFactory(new BehaviorRecordSyncMapperServiceImpl());
        BehaviorRecordSyncMapperService mapperService=(BehaviorRecordSyncMapperService)jdkProxy.getproxy();
     return    mapperService.select(behaviorRecordSync);

    }

}
