package cn.bdqn.gaobingfa.websocket;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class WebMvcConfig  extends WebMvcConfigurerAdapter{
	
	 @Override
	   public void addViewControllers(ViewControllerRegistry registry) {
	       registry.addViewController("/ws").setViewName("/ws");
	       registry.addViewController("/login").setViewName("/login");
	       registry.addViewController("/chat").setViewName("/chat");
	   }

}
