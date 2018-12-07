package cn.bdqn.gaobingfa.thread;

import java.util.Hashtable;
import java.util.Map;

public class MapThread {

    private static Map map;

  static   Runnable runnable=new Runnable() {
        @Override
        public void run() {
                double i = Math.random() * 100000;
             // synchronized (this) {
                  map.put("键" + i, "值" + i);
                  map.remove("键" + i);
                  System.out.println(Thread.currentThread().getName() + "当前时间：" + i + "   size = " + map.size());
            //  }
        }
    };

    public static void main(String[] args) {
        map=new Hashtable();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable,"线程的名字");
            thread.start();
        }
    }
}
