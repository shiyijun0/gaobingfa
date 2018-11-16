package cn.bdqn.gaobingfa.proxy;
/**
 * 目标对象实现类
 * @author shiyijun
 */
public class Man implements Shop {
    @Override
    public void exec() {
        System.out.println("卖男人用品");
    }
}
