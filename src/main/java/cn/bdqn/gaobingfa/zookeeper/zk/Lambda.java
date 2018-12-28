package cn.bdqn.gaobingfa.zookeeper.zk;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
private static int age;
    public static void main(String[] args) {
      /*  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("********");
            }
        }).start();
        //laMbada 简化匿名委托，匿名内部类
        Runnable runnable=()->{
            System.out.println("********lamda**"+Thread.currentThread().getName());
        };
        new Thread(runnable,"线程").start();*/


        Comparable<Integer> comparable=new Comparable<Integer>() {
            @Override
            public int compareTo(Integer o) {
                if((age-o)>0)
                return 1;
                else return -1;
            }
        };


        if("s".compareTo("w")<0){
            System.out.println((byte)'w');
        }
        age=9;
      int s=  comparable.compareTo(2);
        System.out.println(s);

        Comparable<Integer> comparable1=(Integer o)->-1;
        System.out.println(comparable1.compareTo(2));
        //lamda 面向函数接口 只需要一个函数接口
        List<Integer> list=new ArrayList<>();
        //list.stream().forEach();
    }




}
