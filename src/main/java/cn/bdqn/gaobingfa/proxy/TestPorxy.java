package cn.bdqn.gaobingfa.proxy;

public class TestPorxy {
    public static void main(String[] args) {
        Shop shop=new ManProxy(new Man());

        shop.exec();
        System.out.println("******");
    Hua hua=new ManProxy(new Woman());
    hua.hua();
        System.out.println("******");
       /* Shop shop1=new WomanProxy(new Woman());

        shop1.exec();*/


             Schoole schoole=  new Teacher();
            ProxyFactory proxyFactory=new ProxyFactory(schoole);
            Schoole s= (Schoole)  proxyFactory.getProxyInstance();

            s.tea("对方");

    }
}
