package cn.bdqn.gaobingfa;

import cn.bdqn.gaobingfa.Ticket.TickeRunnable;
import cn.bdqn.gaobingfa.controller.BehaviorRecordSyncController;
import cn.bdqn.gaobingfa.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GaobingfaApplicationTests {
    @Autowired
	private BehaviorRecordSyncController behaviorRecordSyncController;
	//public static int count=100;
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

}
