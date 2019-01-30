package cn.bdqn.gaobingfa.springBoot;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

@Component
public class AwareService implements BeanNameAware,ResourceLoaderAware {

    private String beanName;
    private ResourceLoader resourceLoader;
    private static final SimpleDateFormat date=new SimpleDateFormat("HH:mm:ss");
    public AwareService() {
        super();
    }

    @Override
    public void setBeanName(String s) {
    this.beanName=s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
 this.resourceLoader=resourceLoader;
    }

    public void output()  {
        System.out.println("bean的名称为："+beanName);
        Resource resource=resourceLoader.getResource("classpath:syj.txt");
        try {
            System.out.println("加载的内容为："+ IOUtils.toString(resource.getInputStream(),"utf-8"));
        }catch (Exception e){

        }

    }
  private   Properties properties=new Properties();
    public void init() {
        InputStream inputStream= AwareService.class.getClassLoader().getResourceAsStream("classpath:test.properties");
       // BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
        try {
            properties.load(inputStream);
        }catch (Exception e){

        }

    }

    public String key(String key){
        return properties.getProperty(key);
    }


    @Scheduled(fixedRate = 2000)
    public void scheduled(){
        System.out.println("每隔两秒执行一次"+date.format(new Date()));
    }

    @Scheduled(cron = "10 0 0 ? * *")
    public void scheduled1(){
        System.out.println("每隔10******秒执行一次"+date.format(new Date()));
    }


}
