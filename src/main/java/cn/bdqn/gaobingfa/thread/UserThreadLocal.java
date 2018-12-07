package cn.bdqn.gaobingfa.thread;



public class UserThreadLocal {
    private  static  ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    /**
     * 运行3个线程
     */
    public void StartThreadArray(){
        Thread[] runs = new Thread[50];
        for(int i=0;i<runs.length;i++){
            runs[i]=new Thread(new TestThread(i),"线程A"+i);
        }
        for(int i=0;i<runs.length;i++){
            runs[i].start();
        }
    }


    private  static  class TestThread extends Thread{

        private int id;

        public TestThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
           /* id=id+1;
            threadLocal.set(id);
            System.out.println(threadLocal.get()+"********"+Thread.currentThread().getName()+"********"+id);*/
            synchronized (this) {
                int s = 1;

                System.out.println(Thread.currentThread().getName() + ":start");
                // Integer s = threadLocal.get();//获得变量的值
                s = s + id;
               /* while (s > 20) {
                    System.out.println("不能去取款" + s);
                    return;
                }*/
                // threadLocal.set(s);
                System.out.println(Thread.currentThread().getName() + ":"
                        + threadLocal.get());
                System.out.println("***********" + s);


            }
        }
    }

    public static void main(String args[]) throws Exception {
        UserThreadLocal userThreadLocal=new UserThreadLocal();
userThreadLocal.StartThreadArray();
Thread.sleep(1000);
        System.out.println(userThreadLocal.threadLocal.get()+(new TestThread(1)).id);
        }
}
