package cn.bdqn.gaobingfa.Ticket;

import cn.bdqn.gaobingfa.service.MyLockServiceImpl;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.Lock;
@Component
public class TickeRunnable implements Runnable {

  //private   Lock lock=new ReentrantLock();
 //@Resource(name = "myLockServiceImpl")
  private   Lock lock=new MyLockServiceImpl();

    @Override
    public void run() {
        while (TickeTest.count>0){
            lock.lock();
        try {
           // synchronized (this) {
                if (TickeTest.count > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出第" + TickeTest.count-- + "张火车票");
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
