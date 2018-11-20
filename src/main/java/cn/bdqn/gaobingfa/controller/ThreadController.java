package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.Util.RedisRunnable;
import cn.bdqn.gaobingfa.redis.RedisLock;
import cn.bdqn.gaobingfa.redis_suo.DistributedLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/thread")
public class ThreadController {
    int count=100;
    @Autowired
    private DistributedLock distributedLock;
    @Autowired
    private RedisLock redisLock;
    @RequestMapping("/redis")
    @ResponseBody
    public String redis_zookeeper() {
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (count>0){
                    //	lock.lock();
                    String lock="lock:"+ UUID.randomUUID().toString();
                    long time=1000;
                    String value = String.valueOf(time + System.currentTimeMillis());
                    // redisLock.lock(lock,time);
                //    String  indentifier=distributedLock.lockWithTimeout("resource",5000,1000);
                  //  System.out.println("********"+indentifier);
                    // synchronized (this) {
                    if (count > 0) {
                        System.out.println("当前线程" + Thread.currentThread().getName() + "剩余" + count-- + "票");
                    }

                   // boolean flag=  distributedLock.releaseLock("resource", indentifier);
                 //   System.out.println(flag==true);
                    // lock.unlock();
                    // redisLock.unlock(lock,value);
                    // }
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
            }
        };
*/
        RedisRunnable redisRunnable=new RedisRunnable(distributedLock,redisLock);
        for(int i=0;i<10;i++){
            Thread s1=new Thread(redisRunnable,"线程B");
            s1.start();
            Thread s2=new Thread(redisRunnable,"线程C");
            s2.start();
            Thread s3=new Thread(redisRunnable,"线程D");
            s3.start();

            Thread thread=new Thread(redisRunnable,"线程A");
            thread.start();
        }
return "syj";
    }
}
