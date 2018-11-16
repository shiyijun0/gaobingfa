package cn.bdqn.gaobingfa.Ticket;

public class TickeRunnable implements Runnable {


    @Override
    public void run() {
        while (TickeTest.count>0){
        try {
            if(TickeTest.count>0){
                System.out.println(Thread.currentThread().getName()+"售出第"+TickeTest.count--+"张火车票");
            }

        }catch (Exception e){


        }finally {

        }
  try {
      Thread.sleep(100);
  }catch (Exception e){
  e.printStackTrace();
  }


        }
    }
}
