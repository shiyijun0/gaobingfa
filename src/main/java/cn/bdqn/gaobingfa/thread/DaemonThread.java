package cn.bdqn.gaobingfa.thread;

public class DaemonThread {

    private static class UserThread extends Thread{
        @Override
        public void run() {
            System.out.println("**********"+Thread.currentThread().getName());
           try {
             //  Thread.sleep(1000);
               while (isInterrupted()){
                   System.out.println("线程已中断"+isInterrupted()+"***"+interrupted());
               }
           }catch (Exception e){
               System.out.println(interrupted()+"抛出异常"+isInterrupted());
           }finally {
               System.out.println(interrupted()+"结束方法"+isInterrupted());
           }
        }
    }

    public static void main(String args[]) throws InterruptedException {
             UserThread userThread=new UserThread();
             userThread.setName("线程用户");
             userThread.start();
             userThread.interrupt();
            // userThread.join();
             System.out.println("************");
            // userThread.setDaemon(true);


        }
}
