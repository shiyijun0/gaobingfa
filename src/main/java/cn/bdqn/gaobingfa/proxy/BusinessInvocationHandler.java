package cn.bdqn.gaobingfa.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BusinessInvocationHandler implements InvocationHandler {
    private Object target;
    public BusinessInvocationHandler(Object target) {
        super();
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("业务处理前");
        Object result=method.invoke(target, args);
        System.out.println("业务处理后"+args);
        return result;
    }
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader()
                , target.getClass().getInterfaces(), this);
    }

}
