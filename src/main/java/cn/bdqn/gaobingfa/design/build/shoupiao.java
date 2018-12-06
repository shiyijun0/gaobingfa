package cn.bdqn.gaobingfa.design.build;

public class shoupiao implements BuildTicker {
    private Ticket ticket;

    public shoupiao() {
        ticket=new Ticket();
    }


    @Override
    public void quan() {
    ticket.setQuan(100);
    }

    @Override
    public void youhui() {
ticket.setYouhui(50);
    }

    @Override
    public void laoren() {
ticket.setLaoren(10);
    }

    @Override
    public void ertong() {
  ticket.setErtong(20);
    }

    @Override
    public Ticket ticker() {
        return ticket;
    }
}
