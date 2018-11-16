package cn.bdqn.gaobingfa.proxy;
/**
 * 代理类，通过实现与目标对象相同的接口
 * 并维护一个代理对象，通过构造器传入实际目标对象并赋值
 * 执行代理对象实现的接口方法，实现对目标对象实现的干预
 * @author shiyijun
 */
public class ManProxy implements Shop,Hua {

    private Shop shop;

    private Hua hua;

    public ManProxy() {
    }

    public ManProxy(Shop shop) {
        this.shop = shop;
    }

    public ManProxy(Hua hua) {
        this.hua = hua;
    }
    public Hua getHua() {
        return hua;
    }

    public void setHua(Hua hua) {
        this.hua = hua;
    }

    @Override
    public void exec() {
        System.out.println("前拦截");
        shop.exec();
        System.out.println("后拦截");
    }

    @Override
    public void hua() {
        System.out.println("前拦截1");
        hua.hua();
        System.out.println("后拦截1");
    }
}
