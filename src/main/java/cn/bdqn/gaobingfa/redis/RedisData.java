package cn.bdqn.gaobingfa.redis;

import redis.clients.jedis.Jedis;

public class RedisData {

  static   public void exec(){
        Jedis jedis=new Jedis("39.105.169.182");
        String set=jedis.set("loson","7788","NX","PX",10000);
        System.out.println("******"+set);
       // jedis.
        jedis.close();
    }

    public static void main(String[] args) {
        exec();
        exec();
    }
}
