package cn.bdqn.gaobingfa.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws Exception {
        Iorder iorder=new OrderImpl();
        //本地服务注册到6666端口中
        LocateRegistry.createRegistry(6666);
        //把刚才的实例绑定到本地端口上的一个路径
        Naming.bind("rmi://localhost:6666/order",iorder);
        System.out.println("服务已经开始启动");

    }
}
