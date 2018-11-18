package cn.bdqn.gaobingfa.Pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object target;//目标对象

    public JdkProxy(Object target) {
        this.target = target;
    }

    public Object getProxy(){//生成代理对象
      return   Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
              Object result=null;
        System.out.println("拦截前方法");
        result=method.invoke(target,args);
        System.out.println("拦截后方法");

        return result;
    }

    public static void main(String[] args) {
        JdkProxy jdkProxy=new JdkProxy(new JdkDaoImpl());
      JdkDao jdkDao=(JdkDao)  jdkProxy.getProxy();//代理对象和真实对象绑定关系，

        jdkDao.jdk("是一家");
    }
}
