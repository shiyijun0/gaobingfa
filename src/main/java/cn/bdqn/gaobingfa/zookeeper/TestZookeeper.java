package cn.bdqn.gaobingfa.zookeeper;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class TestZookeeper {
    public static int count=10;
    private static List<Integer> list=new LinkedList<>();
    private static Set<Integer> set=new HashSet<>();
 static    ZooKeeperDistributedLock zooKeeperDistributedLock=null;
 static CountDownLatch connectedLatch = new CountDownLatch(1);
  static   Runnable runnable=new Runnable() {
        @Override
        public void run() {

            zooKeeperDistributedLock.acquireDistributedLock();
            while (count>0){
                if(count>0){
                    int i=count--;
                    list.add(i);
                    set.add(i);
                    System.out.println(Thread.currentThread().getName() + "售出第" + i + "张火车票");

                }
            }

            if(zooKeeperDistributedLock!=null) {
                zooKeeperDistributedLock.unlock();
            }
          //  connectedLatch.countDown();
            if(count<=0){
                connectedLatch.countDown();
                System.out.println("*********man*****");
            }
        }
    };

    public static void main(String[] args) throws Exception {
        zooKeeperDistributedLock=new ZooKeeperDistributedLock("1");
        long start=System.currentTimeMillis();
        for (int i=0;i<20;i++){
            Thread thread=new Thread(runnable,"线程"+i);
            thread.start();
        }
        connectedLatch.await();

        System.out.println("****list**"+list.size()+"***set****"+set.size());
        System.out.println("花费的时间为："+(System.currentTimeMillis()-start));
        System.out.println("主线程"+Thread.currentThread().getName());
    }
}
