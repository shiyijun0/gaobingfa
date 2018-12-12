package cn.bdqn.gaobingfa.websocket1;

import cn.bdqn.gaobingfa.Util.JSONUtils;
import cn.bdqn.gaobingfa.Util.ResultData;
import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import cn.bdqn.gaobingfa.service.BehaviorRecordSyncMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ws")
public class WsController {
    @Autowired
    private MyHandler myHandler;
    @Autowired
    private BehaviorRecordSyncMapperService behaviorRecordSyncMapperService;
    @RequestMapping("/name")
    @ResponseBody
    public BehaviorRecordSync object(BehaviorRecordSync behaviorRecordSync) {

        String json= null;
        try {
            json = JSONUtils.beanToJson(ResultData.success(2000,behaviorRecordSync));
            myHandler.sendToRight(json);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("**********推送项目结束");
        }
        return behaviorRecordSync;
    }

    @RequestMapping("")
    public String string(){
        return "websocket/ws";
    }
}
