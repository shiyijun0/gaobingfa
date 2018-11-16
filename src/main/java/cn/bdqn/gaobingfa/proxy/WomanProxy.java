package cn.bdqn.gaobingfa.proxy;

public class WomanProxy implements  Shop {

    private Shop shop;

    public WomanProxy() {
    }

    public WomanProxy(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void exec() {
        System.out.println("执行前");
          shop.exec();
        System.out.println("执行后");
    }
}
