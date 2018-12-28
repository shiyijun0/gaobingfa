package cn.bdqn.gaobingfa.zookeeper.lock;

import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class OrderService implements Runnable {
    private OrderNumGenerator orderNumGenerator=new OrderNumGenerator();
    private static CountDownLatch countDownLatch=new CountDownLatch(50);
    private static List<String> result=new Vector<>();
    @Override
    public void run() {

        System.out.println("***"+countDownLatch.getCount());
        result.add(orderNumGenerator.getNumber());
        System.out.println(result.size()+"*********");
        countDownLatch.countDown();

    }

    public static void main(String[] args)  {
        System.out.println("生成唯一的 订单id");

        for (int i=0;i<50;i++){
            new Thread(new OrderService()).start();
        }

        try {
            countDownLatch.await();
            System.out.println("估计一直处于等待中**********");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Collections.sort(result);
        for (String s:result){
            System.out.println("*****"+s);
        }
    }
}
