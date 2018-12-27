package cn.bdqn.gaobingfa.rmi;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception {
        //通过RMI发现服务并且转成一个对象
        Iorder iorder=(Iorder) Naming.lookup("rmi://localhost:6666/order");
        //远程调用
        System.out.println(iorder.pay("1688880"));
    }
}
