package cn.bdqn.gaobingfa.thread;

public class run {
  // static int j=0;
  static   Thread thread=new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("*******"+Thread.currentThread().getName());
        }
    },"线程B");

 static Runnable runnable=new Runnable() {
      @Override
      public  void run() {
          int j=0;
for(int i=0;i<100;i++){
    System.out.println(++j+"***********"+Thread.currentThread().getName());
}
          System.out.println("&&&&&&&&&&&"+Thread.currentThread().getName());
      }
  };

    public static void main(String args[]) {
             //thread.run();
        //runnable.run();
        Thread thread=new Thread(runnable);
        thread.setName("线程4");
        thread.start();

        Thread thread1=new Thread(runnable);
        thread1.setName("线程5");
        thread1.start();

        Thread thread2=new Thread(runnable);
        thread2.setName("线程6");
        thread2.start();

        Thread thread3=new Thread(runnable);
        thread3.setName("线程7");
        thread3.start();

        }
}
