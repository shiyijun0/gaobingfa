package cn.bdqn.gaobingfa.zookeeper.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CreateSession {
    private static final String host="39.105.169.182:2182";
    private static final String host1="192.168.244.132:2182";
    private static CountDownLatch countDownLatch=new CountDownLatch(1);
    public static void main(String[] args) throws Exception {

        ZooKeeper zooKeeper=new ZooKeeper(host1, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //如果已经获得连接了，sysconnnet
                if(watchedEvent.getState()==Event.KeeperState.SyncConnected){
                    countDownLatch.countDown();
                    System.out.println("******"+watchedEvent.getState());
                }
                if(watchedEvent.getType()==Event.EventType.NodeDataChanged){
                    //如果数据发生变化
                    System.out.println("节点发生了变化，路径:"+watchedEvent.getPath()+"修改的值"+
                            new String());
                }
            }
        });
        countDownLatch.await();
        System.out.println(zooKeeper.getState());
        //创建一个节点  节点的路径   节点的值  acl权限  节点类型
       // zooKeeper.create("/enjoy1","enjoy".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        //获取数据
       byte[] data= zooKeeper.getData("/enjoy1",true,new Stat());
        System.out.println(new String(data));
        //修改数据
        zooKeeper.setData("/enjoy1","deer".getBytes(),-1);
       // zooKeeper.delete("/00000000120000000013",-1);
      List<String> childrens= zooKeeper.getChildren("/d",true);
        System.out.println(childrens);
//当数据或者节点变更的时候通知客户端

        //服务注册和发现


    }
}
