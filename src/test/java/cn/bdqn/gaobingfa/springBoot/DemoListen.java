package cn.bdqn.gaobingfa.springBoot;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListen implements ApplicationListener<DemoEnvent> {
    @Override
    public void onApplicationEvent(DemoEnvent demoEnvent) {
        String msg=demoEnvent.getMsg();
        System.out.println("我收到了信息"+msg);
    }
}
