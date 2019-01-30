package cn.bdqn.gaobingfa.springBoot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.math.BigDecimal;

@Component
@PropertySource("classpath:test.properties")
public class BeanAno {
    @Value("任静")
    private String name;
    @Value("${syj.student}")
    private String student;
    @Value("${syj.weight}")
    private BigDecimal weight;
    @PostConstruct
    private void init(){
        System.out.println("初始化方法");
    }
    @PreDestroy
    private void destory(){
        System.out.println("销毁方法");
    }

    public String getName() {
        return name;
    }

    public String getStudent() {
        return student;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}
