package cn.bdqn.gaobingfa.zookeeper.zkclient;

import org.I0Itec.zkclient.ZkClient;


public class SessionDemo {

    private final static String CONNECTSTRING="192.168.244.132:2182";

    public static void main(String[] args) {
        ZkClient zkClient=new ZkClient(CONNECTSTRING,4000);

        System.out.println(zkClient+" - > success");
    }
}
