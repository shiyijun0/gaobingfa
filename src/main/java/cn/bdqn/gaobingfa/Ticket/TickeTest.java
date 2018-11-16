package cn.bdqn.gaobingfa.Ticket;
//火车票
public class TickeTest {


    public static int count=100;

    public static void main(String[] args) {




       TickeRunnable tickeRunnable=new TickeRunnable();

        Thread thread=new Thread(tickeRunnable,"窗口A");
        Thread thread1=new Thread(tickeRunnable,"窗口B");
        Thread thread2=new Thread(tickeRunnable,"窗口C");
        Thread thread3=new Thread(tickeRunnable,"窗口D");
        Thread thread4=new Thread(tickeRunnable,"窗口E");
        Thread thread5=new Thread(tickeRunnable,"窗口H");

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }




}
