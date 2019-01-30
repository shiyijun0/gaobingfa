package cn.bdqn.gaobingfa.springBoot;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Configuration
@Component
public class springEL {
    @Value("classpath:syj.txt")
    private   Resource resource;
    @Value("#{systemProperties['os.name']}")
    private String osName;

   // @Test
    public  void test1() throws Exception{
        System.out.println(IOUtils.toString(resource.getInputStream(),"utf-8"));
        System.out.println(osName+"***************");
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext=new AnnotationConfigApplicationContext(springEL.class);
        springEL springEL=applicationContext.getBean(cn.bdqn.gaobingfa.springBoot.springEL.class);
        springEL.test1();
        applicationContext.close();
    }
}
