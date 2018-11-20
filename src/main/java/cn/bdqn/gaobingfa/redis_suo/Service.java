package cn.bdqn.gaobingfa.redis_suo;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by liuyang on 2017/4/20.
 */
public class Service {
    private static JedisPool pool = null;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(200);
        // 设置最大空闲数
        config.setMaxIdle(8);
        // 设置最大等待时间
        config.setMaxWaitMillis(1000 * 100);
        // 在borrow一个jedis实例时，是否需要验证，若为true，则所有jedis实例均是可用的
        config.setTestOnBorrow(true);
        pool = new JedisPool(config, "39.105.169.182", 6379, 3000);
    }

    //DistributedLock lock = new DistributedLock(pool);
    DistributedLock lock = new DistributedLock();

    int n = 500; int count=100;

    public void seckill() {
        // 返回锁的value值，供释放锁时候进行判断
        while (count>0){
        String indentifier = lock.lockWithTimeout("resource", 5000, 1000);
       // System.out.println(Thread.currentThread().getName() + "获得了锁"+indentifier);
     if(count>0){
         System.out.println(Thread.currentThread().getName() + "售出第" + count-- + "张火车票");
     }
            boolean flag=  lock.releaseLock("resource", indentifier);
           // System.out.println(flag==true);
     }
       // System.out.println(--n+"********");

    }
}
