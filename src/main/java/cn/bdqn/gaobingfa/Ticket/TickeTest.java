package cn.bdqn.gaobingfa.Ticket;
//火车票

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TickeTest {


    public static int count=100;

    private static  int clientNum = 100000;
    private static int threadsNum = 5000;

    private final static CountDownLatch countDownLatch=new CountDownLatch(clientNum);

    public static void main(String[] args) {
        //建立线程池
        ExecutorService executorService= Executors.newFixedThreadPool(threadsNum);

        for(int i=0;i<1;i++){
          //  TickeRunnable tickeRunnable=new TickeRunnable();
           // executorService.execute(tickeRunnable);
            new Thread(new TickeRunnable(countDownLatch)).start();

            //countDownLatch.await();
        }
        countDownLatch.countDown();// 启动多个线程

      /* TickeRunnable tickeRunnable=new TickeRunnable();

        Thread thread=new Thread(tickeRunnable,"窗口A");
        Thread thread1=new Thread(tickeRunnable,"窗口B");
        Thread thread2=new Thread(tickeRunnable,"窗口C");
        Thread thread3=new Thread(tickeRunnable,"窗口D");
        Thread thread4=new Thread(tickeRunnable,"窗口E");
        Thread thread5=new Thread(tickeRunnable,"窗口H");

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();*/


    }




}
