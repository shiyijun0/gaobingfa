package cn.bdqn.gaobingfa.controller.HttpController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/http")
public class HTTPController {
   // @RequestMapping(value="/doGetControllerOne", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
   @RequestMapping(value="/doGetControllerOne")
    public String doGetControllerOne(String name,String age){
       Map<String, Object> parameters=new HashMap<>();
       if(name!=null){
           parameters.put("name",name);
       }
       if(age!=null){
           parameters.put("age",age);
       }
        StringBuffer stringBuffer=new StringBuffer();
       if(parameters.size()>0) {
           for (String s : parameters.keySet()) {
               stringBuffer.append(s + ":" + parameters.get(s) + "--");
           }

           return stringBuffer.toString().substring(0, stringBuffer.toString().length() - 1);
       }

       return "无参数";

    }

     @RequestMapping(value="/doGet", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public String doGet(@RequestBody Map<String, Object> parameters){
        StringBuffer stringBuffer=new StringBuffer();
        if(parameters.size()>0) {
            for (String s : parameters.keySet()) {
                stringBuffer.append(s + ":" + parameters.get(s) + "--");
            }

            return stringBuffer.toString().substring(0, stringBuffer.toString().length() - 1);
        }

        return "无参数RequestBody";

    }
}
