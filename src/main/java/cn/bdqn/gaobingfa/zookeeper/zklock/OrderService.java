package cn.bdqn.gaobingfa.zookeeper.zklock;

import cn.bdqn.gaobingfa.zookeeper.lock.OrderNumGenerator;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class OrderService implements Runnable {
    private OrderNumGenerator orderNumGenerator=new OrderNumGenerator();
    private Lock lock=new ZKDistributedLock();
    private static CountDownLatch countDownLatch=new CountDownLatch(50);
    private static List<String> result=new Vector<>();
    @Override
    public void run() {


    }

    public void getNumber(){
        try {
            lock.getLock();
            String number=orderNumGenerator.getNumber();
            System.out.println(Thread.currentThread().getName()+"生成的订单为iD"+number);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unLock();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<50;i++){
            new Thread(new OrderService()).start();
        }
    }
}
