package cn.bdqn.gaobingfa.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;


//SpringMVC只扫描Controller；子容器
//useDefaultFilters=false 禁用默认的过滤规则；
@Configuration
@ComponentScan(value="cn.bdqn.gaobingfa",includeFilters={
		@Filter(type=FilterType.ANNOTATION,classes={Controller.class})
},useDefaultFilters=false)
@EnableWebMvc
public class JamesAppConfig extends WebMvcConfigurerAdapter {

	 //拦截器
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new JamesInterceptor()).addPathPatterns("/**");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean filterRegist() {
		FilterRegistrationBean frBean = new FilterRegistrationBean();
		frBean.setFilter(new MyFilter());
		frBean.addUrlPatterns("/*");
		System.out.println("filter************");
		return frBean;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletListenerRegistrationBean listenerRegist() {
		ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
		srb.setListener(new MyHttpSessionListener());
		System.out.println("listener************");
		return srb;
	}
}
