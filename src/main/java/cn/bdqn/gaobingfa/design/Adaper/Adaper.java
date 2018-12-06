package cn.bdqn.gaobingfa.design.Adaper;
//类适配器
public class Adaper extends yuan implements Target {

    @Override
    public void t1() {
        System.out.println("方法执行t1");
    }

    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    @Override
    public void t2() {

    }
}
