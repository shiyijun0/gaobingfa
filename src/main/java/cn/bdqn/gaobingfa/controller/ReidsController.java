package cn.bdqn.gaobingfa.controller;

import com.google.common.collect.Maps;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/redis")
@RestController
public class ReidsController {

    @Resource
    private RedisTemplate<String, Object> stringRedisTemplate;


    @RequestMapping("/tem")
    public Object object(){
        int i = 0;
        try {
            long start = System.currentTimeMillis();

            System.out.println("start:*****" + start);
            while (true) {
                long end = System.currentTimeMillis();
                if (end - start >= 1000) { //大于1000毫秒，相当于1,秒
                    break;
                }
                i++;
                stringRedisTemplate.opsForValue().set("redis_test:"+i,""+i) ;
            }
        }catch (Exception e){

        }
        finally {
            System.out.println("********"+i);
        }

        System.out.println("每秒打印的次数"+i);

        return "每秒打印的次数"+i;
    }

    @RequestMapping("/hash")
    public Object hash(){
        Map<String,Object> map= Maps.newHashMap();
        map.put("sy","val1");
        map.put("sy1","bsl");
        stringRedisTemplate.opsForHash().putAll("hash",map);
        return stringRedisTemplate.opsForHash().entries("hash");
    }

   /* @RequestMapping("/liu")//流水线
    public void liu(){
        //开启流水线
        SessionCallback callback=(SessionCallback) (RedisOperations ops) ->
        {
            for (int i=0;i<100000;i++) {
                int j=i+1;
                ops.boundValueOps("pipe_key"+j).set("pipe_value"+j);
                ops.boundValueOps("pipe_key"+j).get();
            }
           // return null;
            return ops.boundValueOps("pipe_key"+1).get();;
        };
        long start=System.currentTimeMillis();
        List list=stringRedisTemplate.executePipelined(callback);
        long end=System.currentTimeMillis();
        System.out.println(end-start);


    }*/
}
