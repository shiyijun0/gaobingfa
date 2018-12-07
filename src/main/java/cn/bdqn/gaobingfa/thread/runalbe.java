package cn.bdqn.gaobingfa.thread;

public class runalbe implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"$$$$$$$");
        System.out.println("8888888888");
    }

    public static void main(String args[]) {
             Thread  thread=new Thread(new runalbe(),"线程A");
        thread.start();
        //thread.join();
        System.out.println("*******"+thread.getName());
        System.out.println("&&&&&&&&"+Thread.currentThread().getName());
        }
}
