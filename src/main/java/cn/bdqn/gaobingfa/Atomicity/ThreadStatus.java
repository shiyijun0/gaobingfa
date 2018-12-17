package cn.bdqn.gaobingfa.Atomicity;

public class ThreadStatus {

    static  Runnable runnable=new Runnable() {
        @Override
        public void run() {
            while (Thread.currentThread().isInterrupted()) {
                System.out.println("当前线程状态1" + Thread.currentThread().isInterrupted());
                System.out.println(Thread.interrupted());


            }

            if (!Thread.currentThread().isInterrupted()) {
                System.out.println("当前线程状态2" + Thread.currentThread().isInterrupted());
                System.out.println(Thread.interrupted());

            }
        }
    };

    public static void main(String[] args) {
        Thread thread=new Thread(runnable,"线程A");
        thread.start();
       // thread.interrupt();
    }
}
