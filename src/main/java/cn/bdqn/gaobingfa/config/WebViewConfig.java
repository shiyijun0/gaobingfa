package cn.bdqn.gaobingfa.config;


import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

/*@Configuration
@EnableWebMvc
@ComponentScan("cn.bdqn.gaobingfa")*/
public class WebViewConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置模板解析器
     */
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver
                = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    /**
     * 配置模板引擎
     */
    @Bean
    public TemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine =
                new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    /**
     * 配置Thymeleaf模板视图解析器
     */
    @Bean
    public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
        System.err.println("=========================ViewResolver");
        ThymeleafViewResolver viewResolver =
                new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }



    /**
     * 配置静态资源处理
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        // TODO Auto-generated method stub
        configurer.enable();
    }

}
