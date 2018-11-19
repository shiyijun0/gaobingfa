package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis_lock")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;
    @RequestMapping("/find")
  public   String querySecKillProductInfo(String productId){
      return   seckillService.querySecKillProductInfo(productId);
    }

    @RequestMapping("/order")
   public void orderProductMocckDiffUser(String productId){
        seckillService.orderProductMocckDiffUser(productId);
    };
}
