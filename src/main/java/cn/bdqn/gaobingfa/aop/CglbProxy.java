package cn.bdqn.gaobingfa.aop;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglbProxy implements MethodInterceptor {
    private Object target;

    public CglbProxy(Object target) {
        this.target = target;
    }

    //创建代理对象


    public Object getTarget() {
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);//指定目标类生产子类  回调方法

        return enhancer.create();
    }
//回调方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法前处理");
     Object os=  methodProxy.invokeSuper(o,objects);
        System.out.println("方法前处理后");

        return os;

    }

    public static void main(String[] args) {
        TeacherServiceImpl teacherService=new TeacherServiceImpl();
        CglbProxy cglbProxy=new CglbProxy(teacherService);
        TeacherServiceImpl service=(TeacherServiceImpl)  cglbProxy.getTarget();//目标子类
        service.print();
    }
}
