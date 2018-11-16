package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.entity.CardEquipmentSync;
import cn.bdqn.gaobingfa.service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping("/c")
public class CardEquipmentSyncController implements BaseController<CardEquipmentSync> {
    @Resource
    private BaseService<CardEquipmentSync> cardEquipmentSyncBaseService;

   @RequestMapping("/find")
   @ResponseBody
    @Override
    public List<CardEquipmentSync> find() {
        return cardEquipmentSyncBaseService.find();
    }
    @RequestMapping("/insert")
    @ResponseBody
    @Override
    public CardEquipmentSync insert(CardEquipmentSync cardEquipmentSync) {
        return cardEquipmentSyncBaseService.insert(cardEquipmentSync);
    }
    @RequestMapping("/findone")
    @ResponseBody
    @Override
    public CardEquipmentSync findone(long id) {
        return cardEquipmentSyncBaseService.findone(id);
    }
    @RequestMapping("/delete")
    @ResponseBody
    @Override
    public int delete(long id) {
        try {
            cardEquipmentSyncBaseService.delete(id);
        }catch (Exception e){
            return 0;
        }
        return 1;
    }
    @RequestMapping("/update")
    @ResponseBody
    @Override
    public CardEquipmentSync update(CardEquipmentSync cardEquipmentSync) {
        return cardEquipmentSyncBaseService.update(cardEquipmentSync);
    }

    @RequestMapping("/count")
    @ResponseBody
    @Override
    public long count() {
        return cardEquipmentSyncBaseService.count();
    }
}
