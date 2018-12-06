package cn.bdqn.gaobingfa.design.template;

public class Coffee extends template {

    @Override
    public void daoru() {
        System.out.println("倒入咖啡");
    }

    @Override
    public void tang(String tang, String weijing) {
        System.out.println("倒入"+tang+"和倒入"+weijing);
    }


}
