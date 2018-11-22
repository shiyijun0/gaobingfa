package cn.bdqn.gaobingfa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReidsTest {
    @Test
    public void redis() {
        Jedis jedis = new Jedis("39.105.169.182", 6379);
        int i = 0;
        //jedis.auth("1234");
        try {
            long start = System.currentTimeMillis();

            System.out.println("start:*****" + start);
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) {//大于1000毫秒，相当于1,秒
                    break;
                }
                i++;
                jedis.set("redis:"+i,""+i) ;
            }
        } finally {
            jedis.close();
        }

        System.out.println("每秒打印的次数"+i);
        }
    }