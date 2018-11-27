package cn.bdqn.gaobingfa.aop;
//运用cglb实现动态代理模式
public class TeacherServiceImpl {

    public void print() {
        System.out.println("动态代理模式");
    }

    public String string(String name) {
        System.out.println("********"+name);
        return name;
    }
}
