package cn.bdqn.gaobingfa.thread.pool;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：实现一个数据库的连接池
 */
public class DBPool {

	private final static int POOL_SIZE = 10;
	private final Semaphore useful=new Semaphore(POOL_SIZE);//useful表示可用的数据库连接
	private final   Semaphore useless=new Semaphore(0);//useless表示已用的数据库连接

	//数据库池的容器
	private static LinkedList<Connection> pool = new LinkedList<>();
	
	public DBPool(int initalSize) {
		if(initalSize>0) {
			for(int i=0;i<initalSize;i++) {
				pool.addLast(SqlConnectImpl.fetchConnection());
			}
		}
	}
	
	//拿到数据库连接
	public Connection returnConn() throws InterruptedException {
		Connection connection=null;

		useful.acquire();//拿到连接，其他的阻塞
		synchronized (pool){
			pool.removeFirst();
	}
		useless.release();
		return connection;
	};
	
	//放回数据库连接
	public void releaseConn(Connection conn) throws InterruptedException {
		if(conn!=null){
			useless.acquire();
			synchronized (pool){
				pool.addLast(conn);
			}

			useful.release();
		}
	}

 
}
