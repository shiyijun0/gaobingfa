package cn.bdqn.gaobingfa.Pattern;

public class TicketBuilder {

    public static TicketBuilderHelper builder(TicketBuilderHelper builder){
        System.out.println("票类型："+builder);

        return builder;
    }

    public static void main(String args[]) {
             TicketBuilderHelper ticketBuilderHelper=new TicketBuilderHelper();
             ticketBuilderHelper.buildChilden("孩子票");
             ticketBuilderHelper.buildMan("男人票");
             ticketBuilderHelper.buildWoman("女人票");

        TicketBuilderHelper object=TicketBuilder.builder(ticketBuilderHelper);

        System.out.println(object+"************");
        }
}
