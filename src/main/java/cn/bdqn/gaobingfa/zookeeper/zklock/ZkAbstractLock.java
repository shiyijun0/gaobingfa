package cn.bdqn.gaobingfa.zookeeper.zklock;

import org.I0Itec.zkclient.ZkClient;

public abstract class ZkAbstractLock extends AbstractLock {
    private static final String CONNECTSTRING="192.168.244.132:2182";
 protected    ZkClient zkClient=new ZkClient(CONNECTSTRING,4000);
 protected    static    final String PATH="/lock";

    protected    static    final String PATH2="/lock";

    /*public abstract boolean tryLock();
    public abstract void waitLock();*/
}
