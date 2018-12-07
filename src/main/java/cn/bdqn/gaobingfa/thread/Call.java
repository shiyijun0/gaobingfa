package cn.bdqn.gaobingfa.thread;

import java.util.concurrent.*;

public class Call implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("的宣传"+Thread.currentThread().getName());
        return "我能得到的";
    }

    public static void main(String args[]) throws InterruptedException,ExecutionException {

        RunnableFuture<String> future=new FutureTask(new Call());
        Thread thread=new Thread(future,"线程8");

        thread.start();
        future.cancel(false);
        Thread.sleep(100);
        System.out.println(future.isCancelled());
        System.out.println("***er**"+future.get()+future.isDone());//阻塞线程  超时
        System.out.println("************"+future.isCancelled());

        }
}
