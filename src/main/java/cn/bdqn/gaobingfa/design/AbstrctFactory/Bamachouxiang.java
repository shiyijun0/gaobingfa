package cn.bdqn.gaobingfa.design.AbstrctFactory;

import cn.bdqn.gaobingfa.design.Factory.Bag.Bag;
import cn.bdqn.gaobingfa.design.Factory.Bag.BaomaBag;
import cn.bdqn.gaobingfa.design.Factory.Baoma;
import cn.bdqn.gaobingfa.design.Factory.Factory;

public class Bamachouxiang extends AbstrctFactory {
    @Override
    Factory factory() {
        return new Baoma();
    }

    @Override
    Bag bag() {
        return new BaomaBag();
    }
}
