package cn.bdqn.gaobingfa.proxy;

public class BusinessImp implements Business {
    @Override
    public void execute() {
        System.out.println("代理类对象业务处理");
    }
}
