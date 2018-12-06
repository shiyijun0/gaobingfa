package cn.bdqn.gaobingfa.design.Adaper;
//对象适配器
public class Adaper1 {

    private yuan yuan;

    public Adaper1(yuan yuan) {
        this.yuan = yuan;
    }
//直接从原方法中获取
    public void t1() {
       this.yuan.t1();
    }

    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */

    public void t2() {

    }
}
