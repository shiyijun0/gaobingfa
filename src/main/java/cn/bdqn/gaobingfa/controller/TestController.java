package cn.bdqn.gaobingfa.controller;


import cn.bdqn.gaobingfa.aop.RoleService;
import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import cn.bdqn.gaobingfa.entity.User;
import cn.bdqn.gaobingfa.service.BehaviorRecordSyncMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/api")
public class TestController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private BehaviorRecordSyncMapperService behaviorRecordSyncMapperService;

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
        ModelAndView modelAndView = new ModelAndView();
        String name = httpServletRequest.getParameter("name");
        modelAndView.addObject(name);
        System.out.println("********" + name);
        modelAndView.setView(new MappingJackson2JsonView());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping("/parm")
    public ModelAndView parm(@RequestParam("role_name") String roleName , String note){
        System.out.println("******"+roleName);
        System.out.println("*******"+note);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/getrole/{id}/{name}")
    public ModelAndView pathview(@PathVariable("id") Long id,@PathVariable(name = "name") String name){
        ModelAndView modelAndView=new ModelAndView();
        User user=new User();
        user.setName(name);
        modelAndView.addObject(user);
        //设置json视图
        modelAndView.setView(new MappingJackson2JsonView());

        return modelAndView;
    }

    @RequestMapping(value = "/find_page",method = RequestMethod.POST)
    public ModelAndView find_page(@RequestBody BehaviorRecordSync behaviorRecordSync){
      List<BehaviorRecordSync> list= behaviorRecordSyncMapperService.select(behaviorRecordSync);
      ModelAndView modelAndView=new ModelAndView();
      modelAndView.addObject(list);
      modelAndView.setView(new MappingJackson2JsonView());
      return modelAndView;
    }
    @RequestMapping("/page")
    public ModelAndView page(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/array")
    public ModelAndView array(@RequestBody List<String> list){
        ModelAndView modelAndView=new ModelAndView();
        System.out.println(list.size());
        modelAndView.setViewName("index");

        return modelAndView;
    }
    //@RequestBody 将json数据从后台传过来转化为java数组或者集合
    @RequestMapping("/array1")
    public String array1(@RequestBody String[] list, Model model){
        model.addAttribute("sd");//绑定数据
        System.out.println(list.length);
        return "redirect:/api/page";
       // return modelAndView;
    }
//绑定对象重定向  因为重定向是以字符串参数传递的，而现在这个RedirectAttributes 保存到session里，重定向后清除
    @RequestMapping("/bingrole")
    public String bingrole(RedirectAttributes redirectAttributes, BehaviorRecordSync behaviorRecordSync){
        redirectAttributes.addFlashAttribute("behaviorRecordSync",behaviorRecordSync);
        return "redirect:/api/redirectAttributes";

    }
    @RequestMapping("/redirectAttributes")
    public ModelAndView redirectAttributes(BehaviorRecordSync behaviorRecordSync){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setView(new MappingJackson2JsonView());
        modelAndView.addObject(behaviorRecordSync);
        return modelAndView;


    }

    @RequestMapping("/getHeader")
    public String testHeander(@RequestHeader(value = "User-Agent",required = false,defaultValue = "attribute")
                              String userAgent,@CookieValue(value = "JSESSIONID",required = true,defaultValue = "MyJsessionId")
                              String jessionId){
        System.out.println("useger****"+userAgent);
        System.out.println("jessid*****"+jessionId);
        return "index";
    }
}
