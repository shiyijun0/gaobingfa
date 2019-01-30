package cn.bdqn.gaobingfa.springBoot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:test.properties")
@ConfigurationProperties(prefix = "bootdoConfig")
public class BootdoConfig {
    private String student;
    private int weight;

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
