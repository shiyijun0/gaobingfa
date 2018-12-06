package cn.bdqn.gaobingfa.design.decorator;

public class Target implements decorator {
    @Override
    public void prinnt() {
        System.out.println("目标对象急需展示");
    }


}
