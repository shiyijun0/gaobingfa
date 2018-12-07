package cn.bdqn.gaobingfa.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Call implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("的宣传"+Thread.currentThread().getName());
        return "我能得到的";
    }

    public static void main(String args[]) throws InterruptedException,ExecutionException {

        FutureTask<String> future=new FutureTask(new Call());
        Thread thread=new Thread(future,"线程8");
        thread.start();
        System.out.println("*****"+future.get());

        }
}
