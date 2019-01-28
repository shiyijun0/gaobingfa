package cn.bdqn.gaobingfa;

public class Dog extends Anima implements Fly {

    @Override
    public void fly() {
        System.out.println(Fly.sh);
    }

    @Override
    public double d1(double a, double b) {
        return super.d1(a, b);
    }

    static {
        System.out.println("*******动物狗***");
    }

    public Dog() {
        System.out.println("*******构造器动物狗***");
    }
}
