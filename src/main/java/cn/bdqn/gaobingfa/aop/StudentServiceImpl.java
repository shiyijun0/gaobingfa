package cn.bdqn.gaobingfa.aop;

public class StudentServiceImpl implements StudentService {
    @Override
    public void print() {
        System.out.println("动态代理模式");
    }

    @Override
    public String string(String name) {
        System.out.println("********"+name);
        return name;
    }
}
