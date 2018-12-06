package cn.bdqn.gaobingfa.design.single;

import cn.bdqn.gaobingfa.design.Factory.Bag.AoDeCar;

import java.util.concurrent.atomic.AtomicInteger;

public class Single {

    private  static  AtomicInteger atomicInteger=new AtomicInteger(3);

    public static void main(String[] args) {
        atomicInteger.decrementAndGet();
       int s= atomicInteger.incrementAndGet();
       atomicInteger.decrementAndGet();
        System.out.println(s);
    }

    private static AoDeCar instance;

    public  static AoDeCar aoDeCar(){
        if(instance==null){
            synchronized (AoDeCar.class) {
                if(instance==null) {
                     instance=new AoDeCar();
                }
            }
        }

        return instance;
    }
}
