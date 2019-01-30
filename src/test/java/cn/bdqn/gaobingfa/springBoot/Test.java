package cn.bdqn.gaobingfa.springBoot;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {TestContext.class})
@Configuration
@ComponentScan("cn.bdqn.gaobingfa.springBoot")
//@RunWith(SpringRunner.class)
//@EnableScheduling
public class Test {
  //  @Value("#{beanAno.name}")
   // @Value("dfgg对方")
    private String name;
    public BeanAno beanAno1(){
        return new BeanAno();
    }

    @Bean
    public BootdoConfig bootdoConfig(){
        return new BootdoConfig();
    }

/*@Bean(initMethod = "init")
public  AwareService awareService1(){
        return new AwareService();
}*/
    //private String
    @org.junit.Test
    public void test1() throws Exception{
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(BeanAno.class);
        BeanAno beanAno=applicationContext.getBean(BeanAno.class);
       // System.out.println("******"+name);
       System.out.println(new String(beanAno.getStudent().getBytes("ISO-8859-1"),"utf-8")+"&&&&&&"+beanAno.getWeight());

        applicationContext.close();
        System.out.println();
        AnnotationConfigApplicationContext applicationContext1=new AnnotationConfigApplicationContext(Test.class);
        BeanAno beanAno1=(BeanAno)applicationContext1.getBean("beanAno");
        System.out.println(beanAno1.getWeight());
       // for (Bean bean:applicationContext1.getBean)
        AnnotationConfigApplicationContext applicationContext2=new AnnotationConfigApplicationContext(BootdoConfig.class);
        BootdoConfig bootdoConfig=(BootdoConfig)applicationContext2.getBean("bootdoConfig");
        System.out.println(bootdoConfig.getWeight()+"*****");



    }

    @org.junit.Test
    public void test2() throws Exception{
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(Test.class);
        DemoPublish demoPublish=applicationContext.getBean(DemoPublish.class);
        demoPublish.publish("hedddddddddddddd");
        AwareService awareService=applicationContext.getBean(AwareService.class);
        awareService.output();
        System.out.println(awareService.key("name")+"\t"+awareService.key("age"));
        Thread.sleep(10000);
    }
}
