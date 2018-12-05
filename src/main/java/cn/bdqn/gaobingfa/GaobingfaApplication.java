package cn.bdqn.gaobingfa;

import cn.bdqn.gaobingfa.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

@SpringBootApplication
@EnableCaching
//@ServletComponentScan //过滤器
//@EnableAsync
public class GaobingfaApplication extends AsyncConfigurerSupport {

	public static void main(String[] args) {
		SpringApplication.run(GaobingfaApplication.class, args);
	}

	@Bean(name = "userss")
	public User users(){
		User user = new User();

		user.setName("发的丰富的");
		user.setPass("12345");
		return user;
	}


	@Bean(name = "messageSource")
	public MessageSource initMessageSource(){
		ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasename("classpath:messages");
		messageSource.setUseCodeAsDefaultMessage(true);//找不到key不会报异常信息
		messageSource.setCacheSeconds(10);
		//messageSource.setCacheMillis(10*1000);
		return messageSource;
	}
	/*@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/web/");
		//viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/

}
