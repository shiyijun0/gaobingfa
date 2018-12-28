package cn.bdqn.gaobingfa.zookeeper.zklock;

public abstract class AbstractLock implements Lock {
    @Override
    public void getLock() {
        //尝试获取资源
        if(tryLock()){
            System.out.println("获取锁资源#######");
        }else {
            //等待
            waitLock();
            //重新获取锁资源
            getLock();
        }
    }


    //获取锁资源
    public abstract boolean tryLock();


    //等待
    public abstract void waitLock();
}
