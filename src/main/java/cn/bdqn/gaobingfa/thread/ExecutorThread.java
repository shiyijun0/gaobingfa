package cn.bdqn.gaobingfa.thread;


import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorThread   {

   static Runnable runnable=new Runnable() {
        @Override
        public void run() {
            System.out.println("**********"+Thread.currentThread().getName());
          //  FutureTask<String> executorService= ExecutorService.class
        }
    };

  static   ExecutorService s= new  ExecutorService(){
        @Override
        public void shutdown() {

        }

        @Override
        public List<Runnable> shutdownNow() {
            return null;
        }

        @Override
        public boolean isShutdown() {
            return false;
        }

        @Override
        public boolean isTerminated() {
            return false;
        }

        @Override
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return false;
        }

        @Override
        public <T> Future<T> submit(Callable<T> task) {
            return null;
        }

        @Override
        public <T> Future<T> submit(Runnable task, T result) {
            return null;
        }

        @Override
        public Future<?> submit(Runnable task) {
            return null;
        }

        @Override
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
            return null;
        }

        @Override
        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
            return null;
        }

        @Override
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
            return null;
        }

        @Override
        public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }

        @Override
        public void execute(Runnable command) {
      new Thread(command,"电放费").start();
        }
    };

    public static void main(String[] args) throws Exception {
        s.execute(runnable);
     //  Thread thread=new Thread(futureTask,"sdf");
     //  futureTask.get();
    }
}
