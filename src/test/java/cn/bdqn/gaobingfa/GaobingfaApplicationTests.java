package cn.bdqn.gaobingfa;

import cn.bdqn.gaobingfa.controller.BehaviorRecordSyncController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GaobingfaApplicationTests {
    @Autowired
	private BehaviorRecordSyncController behaviorRecordSyncController;

	@Test
	public void contextLoads() {
	int s=	behaviorRecordSyncController.guardCount("81");

		System.out.println("**********"+s);
	}

}
