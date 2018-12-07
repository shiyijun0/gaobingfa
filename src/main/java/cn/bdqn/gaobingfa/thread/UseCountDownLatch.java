package cn.bdqn.gaobingfa.thread;

import java.util.concurrent.CountDownLatch;

public class UseCountDownLatch {

   static CountDownLatch countDownLatch=new CountDownLatch(100);
  static   Runnable runnable=new Runnable() {
        @Override
        public void run() {
            countDownLatch.countDown();
            System.out.println("co计算数组unt"+countDownLatch.getCount());
        }
    };

    public static void main(String[] args) throws Exception {
      UseCountDownLatch useCountDownLatch=  new UseCountDownLatch();
        for(int i=0;i<100;i++){
            Thread thread=new Thread(runnable,"线程"+i);
            thread.start();
            thread.join();
        }
        countDownLatch.await();
        System.out.println("这是主线程");
    }
}
