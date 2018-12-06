package cn.bdqn.gaobingfa.design.Factory;


import cn.bdqn.gaobingfa.design.Factory.Bag.Bag;

/**
 * 工厂方法模式
 */
public interface BagFactory {
    public Bag getBag();//打包指令
}
