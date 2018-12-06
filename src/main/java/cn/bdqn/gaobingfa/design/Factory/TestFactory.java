package cn.bdqn.gaobingfa.design.Factory;

import cn.bdqn.gaobingfa.design.Factory.Bag.AoDeBag;
import cn.bdqn.gaobingfa.design.Factory.Bag.Bag;

public class TestFactory {
    public static void main(String[] args) {
        Factory factory=new AoDe();
        factory.produce();
        Bag aobag=new AoDeBag();
        aobag.pack();
        Factory factory1=new Baoma();
        factory1.produce();
    }
}
