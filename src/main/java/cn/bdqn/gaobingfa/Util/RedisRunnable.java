package cn.bdqn.gaobingfa.Util;

import cn.bdqn.gaobingfa.redis.RedisLock;
import cn.bdqn.gaobingfa.redis_suo.DistributedLock;
import cn.bdqn.gaobingfa.zookeeper.DistributedLockZoo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RedisRunnable implements Runnable {

    private Lock lock=new ReentrantLock();
    private DistributedLock distributedLock;
    private RedisLock redisLock;
    private  int count=100;
    public RedisRunnable() {
    }

    public RedisRunnable(DistributedLock distributedLock,RedisLock redisLock) {
        this.distributedLock=distributedLock;
        this.redisLock=redisLock;
    }
    @Override
    public void run() {
        DistributedLockZoo distributedLockZoo1 =null;

        try {
            distributedLockZoo1 = new DistributedLockZoo("39.105.169.182:2181", "lock2");

            while (count > 0) {
                distributedLockZoo1.lock();
                //lock.lock();
                //String lock="lock:"+ UUID.randomUUID().toString();
                long time = 10000;
                String value = String.valueOf(time + System.currentTimeMillis());
                // if(redisLock.lock(lock,time)) {
              //  String indentifier = distributedLock.lockWithTimeout("resource", 5000, 1000);
                // System.out.println("********"+indentifier);
                // synchronized (this) {
                if (count > 0) {
                    System.out.println("当前线程" + Thread.currentThread().getName() + "剩余" + count-- + "票");
                }
                // }
              //  boolean flag = distributedLock.releaseLock("resource", indentifier);
                // System.out.println(flag==true);
                //lock.unlock();
                // redisLock.unlock(lock,value);
                // }

            }
            }catch(Exception e){

            }finally{
               if(distributedLockZoo1 !=null){
                   distributedLockZoo1.unlock();
               }
            }


            try {
                Thread.sleep(100);
            }catch (Exception e){

            }


    }
}
