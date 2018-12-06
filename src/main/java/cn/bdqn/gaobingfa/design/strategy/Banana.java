package cn.bdqn.gaobingfa.design.strategy;

public class Banana implements Fruits {
    @Override
    public String sell(int price) {
        return "以打一折形式卖香蕉给大家"+price*0.1;
    }
}
