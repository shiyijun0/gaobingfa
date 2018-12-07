package cn.bdqn.gaobingfa.thread;



public class UserThreadLocal {
    private ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public static void main(String args[]) {
        UserThreadLocal userThreadLocal=new UserThreadLocal();

        System.out.println(userThreadLocal.threadLocal.get());
        }
}
