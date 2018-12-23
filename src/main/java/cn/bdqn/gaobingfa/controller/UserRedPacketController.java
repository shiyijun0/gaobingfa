package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.service.redPacket.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/userRedPacket")
public class UserRedPacketController {

    @Autowired
    private UserRedPacketService userRedPacketService = null;


    @Resource
    private RedisTemplate<String, Object> stringRedisTemplate;

    @Autowired
    public StringRedisTemplate stringRedisTemplate1;

    @RequestMapping("/packet")
    public String grap(){
        return "packet";
    }

    @RequestMapping(value = "/grapRedPacket",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> grapRedPacket(Long redPacketId, Long userId) {
        // 抢红包
        int result = userRedPacketService.grapRedPacket(redPacketId, userId);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;
        retMap.put("success", flag);
        retMap.put("message", flag ? "抢红包成功" : "抢红包失败");
        return retMap;
    }


    //乐观锁请求，使用时修改javascript的请求路径
    @RequestMapping(value = "/grapRedPacketForVersion",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> grapRedPacketForVersion(Long redPacketId, Long userId) {
        // 抢红包
        int result = userRedPacketService.grapRedPacketForVersion(redPacketId, userId);
        Map<String, Object> retMap = new HashMap<String, Object>();
        boolean flag = result > 0;
        retMap.put("success", flag);
        retMap.put("message", flag ? "抢红包成功" : "抢红包失败");
        return retMap;
    }

    @RequestMapping(value = "/grapRedPacketByRedis",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> grapRedPacketByRedis(Long redPacketId, Long userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Long result = userRedPacketService.grapRedPacketByRedis(redPacketId, userId);
        boolean flag = result > 0;
        resultMap.put("result", flag);
        resultMap.put("message", flag ? "抢红包成功": "抢红包失败");
        return resultMap;
    }

    @RequestMapping(value = "/stringRedisTemplate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> stringRedisTemplate(Long redPacketId, Long userId) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        Long result = userRedPacketService.stringRedisTemplate(redPacketId, userId);
        boolean flag = result > 0;
        resultMap.put("result", flag);
        resultMap.put("message", flag ? "抢红包成功": "抢红包失败");
        return resultMap;
    }


}
