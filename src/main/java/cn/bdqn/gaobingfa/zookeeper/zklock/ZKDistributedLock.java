package cn.bdqn.gaobingfa.zookeeper.zklock;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

public class ZKDistributedLock extends  ZkAbstractLock  {

    private CountDownLatch countDownLatch=null;
    @Override
    public  boolean tryLock(){
        try {
            zkClient.createEphemeral(PATH);
            return true;
        }catch (Exception e){
            return false;
        }

    }
    @Override
    public void waitLock(){
        IZkDataListener iZkDataListener=new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                //唤醒被等待的线程
                if(countDownLatch!=null){
                    countDownLatch.countDown();
                }
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {

            }
        };

        zkClient.subscribeDataChanges(PATH,iZkDataListener);

        //如果有节点在
        if(zkClient.exists(PATH)){
            countDownLatch=new CountDownLatch(1);
            try {
                //等待，一直等到受到事件的通知
                countDownLatch.await();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        //删除监听
        zkClient.unsubscribeDataChanges(PATH,iZkDataListener);
    }


    @Override
    public void unLock() {
//释放锁
        if(zkClient!=null){
            zkClient.delete(PATH);
            zkClient.close();
            System.out.println("释放锁资源");
        }
    }

}
