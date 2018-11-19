package cn.bdqn.gaobingfa.Ticket;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class TickeRunnable implements Runnable {
    public static int count=100;
 private   Lock lock=new ReentrantLock();

    private  CountDownLatch countDownLatch;

    public TickeRunnable() {
    }

    public TickeRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    /*@Resource(name = "myLockServiceImpl")
      private   Lock lock;*/
    @Override
    public void run() {

        while (count>0){
            lock.lock();
        try {
            // 线程等待
            countDownLatch.await();
            //synchronized (this) {
                if (count > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出第" + count-- + "张火车票");
                }
         //   }
        }catch (Exception e){


        }finally {
      lock.unlock();
        }
  try {
      Thread.sleep(100);
  }catch (Exception e){
  e.printStackTrace();
  }
        }
    }
}
