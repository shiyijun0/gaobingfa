package cn.bdqn.gaobingfa.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理对象，无需实现任何接口
 * 通过传入任何类型的目标对象并指定接口
 * 调用JDK接口动态创建代理对象
 * @author jiyukai
 */
public class ProxyFactory  {//implements InvocationHandler

    private Object targetObject;

    public ProxyFactory(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(), //和目标对象的类加载器保持一致
                targetObject.getClass().getInterfaces(), //目标对象实现的接口，因为需要根据接口动态生成对象
                new InvocationHandler() { //InvocationHandler:事件处理器，即对目标对象方法的执行

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("前拦截...");

                        Object result = method.invoke(targetObject, args);

                        System.out.println("后拦截...");
                        return result;
                    }
                });
    }

   /* public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(), //和目标对象的类加载器保持一致
                targetObject.getClass().getInterfaces(), //目标对象实现的接口，因为需要根据接口动态生成对象
                this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前拦截...");

        Object result = method.invoke(targetObject, args);

        System.out.println("后拦截...");
        return result;
    }*/

    public static void main(String[] args) {
        Business business=new BusinessImp();

        ProxyFactory businessProxy=new ProxyFactory(business);

        Business business1=(Business)businessProxy.getProxyInstance();
        business1.execute();
    }
}
