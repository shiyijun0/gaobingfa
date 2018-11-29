package cn.bdqn.gaobingfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageSource messageSource;
	@RequestMapping("/msgpage")
	public String page(Model model) {
		model.addAttribute("msgs","username.already.exists");
		//MessageSource resources = new ClassPathXmlApplicationContext("beans.xml");
		String message = messageSource.getMessage("mobile.is.null", null, "Default", null);
		model.addAttribute("message",message);
		System.out.println(message);
		return "msgpage";
	}
}
