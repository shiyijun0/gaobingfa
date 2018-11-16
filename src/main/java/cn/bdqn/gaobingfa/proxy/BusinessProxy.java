package cn.bdqn.gaobingfa.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BusinessProxy implements InvocationHandler {

    private Object target;//真实对象

    public BusinessProxy() {
    }

    public BusinessProxy(Object target) {
        super();
        this.target = target;
    }

    public Object getObject() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("蓝桥1");
        Object o=method.invoke(target,args);
        System.out.println("足球啊");
        return o;
    }

    public static void main(String[] args) {
        Business business=new BusinessImp();

        BusinessProxy businessProxy=new BusinessProxy(business);

       Business business1=(Business)businessProxy.getObject();
       business1.execute();

    }
}
