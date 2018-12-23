package cn.bdqn.gaobingfa.Atomicity;

import java.util.concurrent.atomic.AtomicBoolean;

public class Atomicity {
    static     AtomicBoolean atomicBoolean=new AtomicBoolean(false);
private static int num;

static  Runnable runnable= new Runnable(){
    @Override
    public void run() {
       while (num<100){
           if(num<50){
               System.out.println(Thread.currentThread().getName()+":"+num++);

           }else {
               return;
           }

       }
    }
};
    public static void main(String[] args) {
for (int i=0;i<3;i++){
    Thread thread = new Thread(runnable, "线程******" + i);
    if(atomicBoolean.compareAndSet(false,true)) {
        System.out.println("******111********");
        thread.start();

    }
   // atomicBoolean.compareAndSet(true,false);
    System.out.println("*********"+i);
}

       atomicBoolean.compareAndSet(true,false);
        System.out.println("当前主线程："+Thread.currentThread().getName());
    }
}
