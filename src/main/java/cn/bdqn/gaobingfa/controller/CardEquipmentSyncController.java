package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.entity.CardEquipmentSync;
import cn.bdqn.gaobingfa.service.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping("/c")
@Api(tags = "卡设备")
@ApiModel
public class CardEquipmentSyncController implements BaseController<CardEquipmentSync> {
    @Resource
    private BaseService<CardEquipmentSync> cardEquipmentSyncBaseService;

   @RequestMapping("/find")
   @ResponseBody
   @ApiOperation(value = "查找设备对象",notes = "根据对应业务规则添加相应的产品")
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
    @ApiModelProperty(value="ID",dataType="String",name="ID",example="1020332806740959233")
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
