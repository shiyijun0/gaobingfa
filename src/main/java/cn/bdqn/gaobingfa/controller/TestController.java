package cn.bdqn.gaobingfa.controller;

import cn.bdqn.gaobingfa.aop.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/api")
public class TestController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"/test","/test1"},method = RequestMethod.GET,produces={"application/json"})
    @ResponseBody
    public Object test(){
        return "施以军1234";
    }

    @PostMapping("/test1")
    @ResponseBody
    public Object test1(){
        return "施以军1234";
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index1(HttpSession httpSession, HttpServletRequest httpServletRequest){
        //, @SessionAttribute(name = "age",required = false) int age
        ModelAndView modelAndView=new ModelAndView();
      String  name=  httpServletRequest.getParameter("name");
      modelAndView.addObject(name);
        System.out.println("********"+name);
       modelAndView.setView(new MappingJackson2JsonView());
        modelAndView.setViewName("index");
        return modelAndView;
    }


}
