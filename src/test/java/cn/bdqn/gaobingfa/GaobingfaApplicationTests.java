package cn.bdqn.gaobingfa;

import cn.bdqn.gaobingfa.Ticket.TickeRunnable;
import cn.bdqn.gaobingfa.controller.BehaviorRecordSyncController;
import cn.bdqn.gaobingfa.controller.SeckillController;
import cn.bdqn.gaobingfa.redis.RedisLock;
import cn.bdqn.gaobingfa.redis.RedisUtil;
import cn.bdqn.gaobingfa.redis_suo.DistributedLock;
import cn.bdqn.gaobingfa.service.IRedisService;
import cn.bdqn.gaobingfa.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.UUID;
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
		int s = behaviorRecordSyncController.guardCount("81");

		System.out.println("**********" + s);
	}

	@Test
	public void testlock() {
		//TickeRunnable tickeRunnable=new TickeRunnable();

		Thread thread = new Thread(tickeRunnable, "窗口A");
		Thread thread1 = new Thread(tickeRunnable, "窗口B");
		Thread thread2 = new Thread(tickeRunnable, "窗口C");
		Thread thread3 = new Thread(tickeRunnable, "窗口D");
		Thread thread4 = new Thread(tickeRunnable, "窗口E");
		Thread thread5 = new Thread(tickeRunnable, "窗口H");

		thread.start();
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

	@Test
	public void setReids() {
		//RedisProperties.Jedis
		redisUtil.setRedisTemplate(redisTemplate);

		redisUtil.set("syj12", "史蒂夫");
		System.out.println("********" + redisUtil.get("syj12"));

	}

	/**
	 * 模拟client_num个客户端同时访问
	 */
	private static int clientNum = 100000;
	private static int threadsNum = 500;
	/**
	 * 计数器
	 */
	final static CountDownLatch doneSignal = new CountDownLatch(clientNum);

	@Autowired
	private SeckillService seckillService;

	@Test
	public void countDownLatch() {
		/**
		 * 建立线程池
		 */
		ExecutorService exec = Executors.newFixedThreadPool(threadsNum);
		for (int i = 0; i < clientNum; i++) {
			MyRunnable myRunnable = new MyRunnable();
			//exec.execute(myRunnable);
			//	doneSignal.countDown();
			Thread thread = new Thread(myRunnable, "A" + i);
			thread.start();
			Thread thread1 = new Thread(myRunnable, "A" + i + "1");
			thread1.start();
			Thread thread2 = new Thread(myRunnable, "A" + i + "2");
			thread2.start();

			/*seckillController.orderProductMocckDiffUser("123456");
			System.out.println("******"+seckillController.querySecKillProductInfo("123456"));*/

		}
	}

	static class MyRunnable implements Runnable {

		private Lock lock = new ReentrantLock();
		private static int count = 500;

		@Override
		public void run() {
			try {
				//doneSignal.await();
			} catch (Exception e) {
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
	public void jdes() {
		Jedis jedis = new Jedis("39.105.169.182");
		String set = jedis.set("loson", "7788", "NX", "PX", 100000);
		System.out.println("******" + set);
		jedis.close();
	}
private int count=100;
	private Lock lock=new ReentrantLock();
	@Autowired
	private DistributedLock distributedLock;
	@Autowired
	private RedisLock redisLock;
	@Test
	public void redis_zookeeper() {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
              while (count>0){
              //	lock.lock();
				  String lock="lock:"+UUID.randomUUID().toString();
				  long time=1000;
				  String value = String.valueOf(time + System.currentTimeMillis());
				 // redisLock.lock(lock,time);
				  String  indentifier=distributedLock.lockWithTimeout("resource",5000,1000);
				  System.out.println("********"+indentifier);
				  // synchronized (this) {
				 if (count > 0) {
					 System.out.println("当前线程" + Thread.currentThread().getName() + "剩余" + count-- + "票");
				 }

				  boolean flag=  distributedLock.releaseLock("resource", indentifier);
				  System.out.println(flag==true);
				// lock.unlock();
				 // redisLock.unlock(lock,value);
			// }
				try {
              		Thread.sleep(100);
				}catch (Exception e){

				}
			  }
			}
		};


		for(int i=0;i<40;i++){
			Thread s1=new Thread(runnable,"线程B");
			s1.start();
			Thread s2=new Thread(runnable,"线程C");
			s2.start();
			Thread s3=new Thread(runnable,"线程D");
			s3.start();

			Thread thread=new Thread(runnable,"线程A");
			thread.start();
		}

	}
	@Autowired
	private IRedisService iRedisService;

    @Test
	public  void  redis_tempalet(){
     redisTemplate.opsForValue().set("suwei","苏伟");
		System.out.println("******"+redisTemplate.opsForValue().get("suwei"));

	}
}