package cn.bdqn.gaobingfa.rmi.rpc;

/**
 * 消费对象获取代理对象并调用服务
 */
public class RpcConsumer {
    public static void main(String[] args) throws Exception {
        HelloService proxy = RpcProxyFactory.getService(HelloService.class);
        String result = proxy.sayHello("wo发过火和rld");
        System.out.println(result);
    }

    /**
     * 这个简易实例中，整个RPC原理很清晰，上面用例中最核心的一点，就是当proxy.sayHello执行的时候，实际是在执行RpcHandler的invoke方法，
     * 也就是远程调用。
     如果要真正实现一个企业级RPC框架，仅仅有这个原理还是不够的。还需要考虑很多东西，例如建立连接的时候，
     使用NIO从而使得IO效率更高；或者在集群中，暴露服务的ip和端口都是动态的，而消费者此时也不能将要调用的服务提供方的ip和端口写死，于是需要一个注册中心的角色，产生注册服务、订阅服务等事件。

     */
}
