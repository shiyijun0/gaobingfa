package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.config.MyHttpSessionListener;
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
import org.springframework.web.context.request.async.DeferredResult;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;

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


    @RequestMapping("/req")
    @ResponseBody
    public Callable<List<BehaviorRecordSync>> object(){
        System.out.println("主线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
Callable<List<BehaviorRecordSync>> callable=new Callable<List<BehaviorRecordSync>>() {
    @Override
    public List<BehaviorRecordSync> call() throws Exception {

        try {
            System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
            return baseService.find();
        } finally {
            System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
        }


    }

};
        System.out.println("主线程结束..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
return callable;

    }
    @RequestMapping("/online")
    @ResponseBody
    public Object online() {
        return  "当前在线人数：" + MyHttpSessionListener.online + "人";
    }

    //其实相当于我们说的tomcat的线程1，来处理用户请求，并将请求的操作放到Queue队列里
    @ResponseBody
    @RequestMapping("/createOrder")
    public DeferredResult<Object> createOrder(){
        DeferredResult<Object> deferredResult = new DeferredResult<>((long)10000, "create fail...");

        JamesDeferredQueue.save(deferredResult);

        return deferredResult;
    }

    ////其实相当于我们说的tomcat的线程N，来处理用户请求，并将请求的操作放到Queue队列里
    @ResponseBody
    @RequestMapping("/create")
    public String create(){
        //创建订单（按真实操作应该是从订单服务取，这里直接返回）
        String order = UUID.randomUUID().toString();//模拟从订单服务获取的订单信息（免调接口）
        DeferredResult<Object> deferredResult = JamesDeferredQueue.get();
        deferredResult.setResult(order);
        return "create success, orderId == "+order;
    }


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
