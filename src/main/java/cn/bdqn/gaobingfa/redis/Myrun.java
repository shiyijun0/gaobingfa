package cn.bdqn.gaobingfa.redis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Myrun implements Runnable {
   int count=100;
   private Lock lock=new ReentrantLock();
    @Override
    public void run() {
        while (count>0){
          //  lock.lock();
            if(count>0){
                System.out.println("当前线程"+Thread.currentThread().getName()+"剩余"+count--+"票");
            }
         //  lock.unlock();
            try {
                Thread.sleep(50);
            }catch (Exception e){

            }

        }
    }
}
