package cn.bdqn.gaobingfa.controller.vue;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vue")
@Controller
public class VueController {

     final  static String VUE="/vue";
     @RequestMapping("/hello")
    public String hello(){
        return VUE+"/hello";
    }
}
