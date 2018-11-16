package cn.bdqn.gaobingfa.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class JunProxy implements MethodInterceptor {


    public Object getProxy(Class<?> clazz){
        Enhancer enchancer=new Enhancer();
        enchancer.setSuperclass(clazz);
        enchancer.setCallback(this);
        return enchancer.create();
    }


    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("业务处理前");
        Object result=proxy.invokeSuper(obj, args);
        System.out.println("业务处理后");
        return result;
    }
    public static void main( String[] args )
    {
        JunProxy businessProxy=new JunProxy();
        JUN jun=(JUN) businessProxy.getProxy(JUN.class);
        //jun.ed
    }

}
