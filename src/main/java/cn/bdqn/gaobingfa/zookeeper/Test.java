package cn.bdqn.gaobingfa.zookeeper;

/**
 * Created by liuyang on 2017/4/20.
 */
public class Test {
    static int n = 500;

    public static int count=1000;

    public static void secskill() {
        System.out.println(--n+"**************");
    }

    public static void main(String[] args) {


        Runnable runnable = new Runnable() {
            public void run() {
                DistributedLock lock = null;
                try {
                    lock = new DistributedLock("39.105.169.182:2181", "test1");
                    while (count>0){
                        lock.lock();
                        //secskill();
                        if(count>0) {
                           // System.out.println(Thread.currentThread().getName() + "正在运行");
                            System.out.println(Thread.currentThread().getName() + "售出第" + count-- + "张火车票");
                        }
                    }

                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
