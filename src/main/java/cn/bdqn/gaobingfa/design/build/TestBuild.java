package cn.bdqn.gaobingfa.design.build;

public class TestBuild {

    public static Ticket ticket(shoupiao shoupiao) {
        shoupiao.ertong();
        shoupiao.laoren();
        shoupiao.quan();
        shoupiao.youhui();
        return shoupiao.ticker();

    }

    public static void main(String[] args) {
     Ticket ticket=  TestBuild.ticket(new shoupiao());
        System.out.println(ticket.getErtong());

    }
}
