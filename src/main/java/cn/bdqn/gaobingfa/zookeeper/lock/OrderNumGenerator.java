package cn.bdqn.gaobingfa.zookeeper.lock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderNumGenerator {

    public static int count=0;
    public static Object lock=new Object();

    private Lock lock1=new ReentrantLock();

    public String getNumber(){
        lock1.lock();
        try {
            //  synchronized (lock) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            return simpleDateFormat.format(new Date()) + "-" + ++count;
            //  }
        }finally {
            System.out.println("*lock********");
            lock1.unlock();
        }


    }

}
