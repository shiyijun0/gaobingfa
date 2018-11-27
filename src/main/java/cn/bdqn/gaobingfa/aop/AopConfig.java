package cn.bdqn.gaobingfa.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy //开启动态代理
@ComponentScan("cn.bdqn.gaobingfa.aop")
public class AopConfig {

    @Bean
    public RoleAspect gerRoleAspect(){
        return new RoleAspect();
    }
}
