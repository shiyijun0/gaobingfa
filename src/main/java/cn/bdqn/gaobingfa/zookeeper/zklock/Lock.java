package cn.bdqn.gaobingfa.zookeeper.zklock;

public interface Lock {

   void getLock();
   void  unLock();
}
