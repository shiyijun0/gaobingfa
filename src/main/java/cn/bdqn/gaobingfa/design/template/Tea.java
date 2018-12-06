package cn.bdqn.gaobingfa.design.template;

public class Tea extends template {
    @Override
    public void daoru() {
        System.out.println("倒入茶叶");
    }

    @Override
    public void tang(String tang,String weijing) {
        System.out.println("加入"+tang);
    }

    // 钩子函数，是否需要定置  子类复写父类方法
    @Override
    protected boolean isCustomered() {

        return true;
    }
}
