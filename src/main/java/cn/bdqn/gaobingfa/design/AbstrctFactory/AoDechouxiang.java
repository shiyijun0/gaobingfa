package cn.bdqn.gaobingfa.design.AbstrctFactory;

import cn.bdqn.gaobingfa.design.Factory.AoDe;
import cn.bdqn.gaobingfa.design.Factory.Bag.AoDeBag;
import cn.bdqn.gaobingfa.design.Factory.Bag.Bag;
import cn.bdqn.gaobingfa.design.Factory.Factory;

public class AoDechouxiang extends AbstrctFactory {
    @Override
    Factory factory() {
        return new AoDe();
    }

    @Override
    Bag bag() {
        return new AoDeBag();
    }
}
