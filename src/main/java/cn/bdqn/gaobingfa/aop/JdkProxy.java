package cn.bdqn.gaobingfa.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {
    private Object target;
    public JdkProxy(Object object) {
        this.target=object;
    }

    public Object getTarget() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("业务处理前");
        Object result=method.invoke(target, args);
        System.out.println("业务处理后"+args);
        return result;
    }

    public static void main(String[] args) {
        StudentService studentService=new StudentServiceImpl();

        JdkProxy jdkProxy=new JdkProxy(studentService);

        StudentService studentService1=(StudentService) jdkProxy.getTarget();//真实对象和动态代理对象进行绑定，真实对象授权给动态代理对象，进行真实对象才操作
        //此时是代理对象，但是有真实对象功能
        System.out.println(studentService1.string("是符合地方"));
    }
}
