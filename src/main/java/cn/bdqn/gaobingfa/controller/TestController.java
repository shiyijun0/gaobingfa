package cn.bdqn.gaobingfa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        return "施以军1234";
    }

    @PostMapping("/test1")
    @ResponseBody
    public Object test1(){
        return "施以军1234";
    }
}
