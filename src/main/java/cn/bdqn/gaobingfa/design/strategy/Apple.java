package cn.bdqn.gaobingfa.design.strategy;

public class Apple implements Fruits {
    @Override
    public String sell(int price) {
        return "以打5折价格卖出去苹果"+price*0.5;
    }
}
