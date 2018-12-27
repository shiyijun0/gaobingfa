package cn.bdqn.gaobingfa.rmi.rpc;

import java.lang.reflect.Proxy;

/**
 *
 * 代理工厂
 消费方获取代理对象，使用JDK的动态代理API，传入接口类名。生成代理对象的时候，需
 要传入一个实现了InvocationHandler的对象，也就是下面的RpcHandler
 */
public class RpcProxyFactory {
    public static <T> T getService(Class<T> interfaceClass) {

        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[] { interfaceClass },
                new RpcHandler());
    }


}
