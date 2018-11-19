package cn.bdqn.gaobingfa;

import cn.bdqn.gaobingfa.Ticket.TickeRunnable;
import cn.bdqn.gaobingfa.controller.BehaviorRecordSyncController;
import cn.bdqn.gaobingfa.controller.SeckillController;
import cn.bdqn.gaobingfa.redis.RedisUtil;
import cn.bdqn.gaobingfa.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GaobingfaApplicationTests {
    @Autowired
	private BehaviorRecordSyncController behaviorRecordSyncController;
	//public static int count=100;

	@Autowired
	private SeckillController seckillController;

  @Autowired
  private TickeRunnable tickeRunnable;

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private RedisUtil redisUtil;

	@Test
	public void contextLoads() {
	int s=	behaviorRecordSyncController.guardCount("81");

		System.out.println("**********"+s);
	}

	@Test
	public  void  testlock(){
		//TickeRunnable tickeRunnable=new TickeRunnable();

		Thread thread=new Thread(tickeRunnable,"窗口A");
		Thread thread1=new Thread(tickeRunnable,"窗口B");
		Thread thread2=new Thread(tickeRunnable,"窗口C");
		Thread thread3=new Thread(tickeRunnable,"窗口D");
		Thread thread4=new Thread(tickeRunnable,"窗口E");
		Thread thread5=new Thread(tickeRunnable,"窗口H");

		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

	@Test
	public void setReids(){
		//RedisProperties.Jedis
		redisUtil.setRedisTemplate(redisTemplate);

		redisUtil.set("syj12","史蒂夫");
		System.out.println("********"+redisUtil.get("syj12"));

	}

	/**
	 * 模拟client_num个客户端同时访问
	 */
	private static  int clientNum = 100000;
	private static int threadsNum = 500;
	/**
	 * 计数器
	 */
	final static CountDownLatch doneSignal = new CountDownLatch(clientNum);

	@Autowired
	private SeckillService seckillService;
	@Test
	public  void  countDownLatch(){
		/**
		 * 建立线程池
		 */
		ExecutorService exec = Executors.newFixedThreadPool(threadsNum);
		for(int i=0 ; i< clientNum; i++){
			MyRunnable myRunnable = new MyRunnable();
			//exec.execute(myRunnable);
		//	doneSignal.countDown();
              Thread thread=new Thread(myRunnable,"A"+i);
              thread.start();
			Thread thread1=new Thread(myRunnable,"A"+i+"1");
			thread1.start();
			Thread thread2=new Thread(myRunnable,"A"+i+"2");
			thread2.start();

			/*seckillController.orderProductMocckDiffUser("123456");
			System.out.println("******"+seckillController.querySecKillProductInfo("123456"));*/

		}
	}

	static class  MyRunnable implements  Runnable{

		private Lock lock=new ReentrantLock();
         private static  int count= 500;
		@Override
		public void run() {
			try{
				//doneSignal.await();
			}catch (Exception e){
				e.printStackTrace();
			}
			/*seckillController.orderProductMocckDiffUser("123456");
			System.out.println("******"+seckillController.querySecKillProductInfo("123456"));*/
			//synchronized (this) {
				while (count > 0) {
					lock.lock();
					if (count > 0) {
						System.out.println("***********" + --count);
					}

					lock.unlock();
				}
			//}
		}
	}

    @Test
	public void  jdes(){
	Jedis jedis=new Jedis("39.105.169.182");
	String set=jedis.set("loson","7788","NX","PX",100000);
	System.out.println("******"+set);
	jedis.close();
}

	}

