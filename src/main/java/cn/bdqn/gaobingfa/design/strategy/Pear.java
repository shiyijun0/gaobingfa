package cn.bdqn.gaobingfa.design.strategy;

public class Pear implements Fruits {
    @Override
    public String sell(int price) {
         return "以不打折形式卖梨子给大家"+price;
    }
}
