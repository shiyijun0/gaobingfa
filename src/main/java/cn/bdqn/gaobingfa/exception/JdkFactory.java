package cn.bdqn.gaobingfa.exception;

import cn.bdqn.gaobingfa.annotation.PrivilegeInfo;
import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import cn.bdqn.gaobingfa.service.BehaviorRecordSyncMapperService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkFactory implements InvocationHandler {

    private Object behaviorRecordSyncMapperService;

    public JdkFactory(BehaviorRecordSyncMapperService behaviorRecordSyncMapperService) {
        this.behaviorRecordSyncMapperService = behaviorRecordSyncMapperService;
    }

    //绑定代理和被代理关系，让代理拿到被代理的执行权
    public Object getproxy(){
        return Proxy.newProxyInstance(behaviorRecordSyncMapperService.getClass().getClassLoader(),behaviorRecordSyncMapperService.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("绑定之前做的事情");
        if(method.isAnnotationPresent(PrivilegeInfo.class)){
            // 2。得到注册对象
            PrivilegeInfo pif = method
                    .getAnnotation(PrivilegeInfo.class);
            // 3.得到权限名称
            String pname = pif.value();
            System.out.println("&&&&&&&&&&&&&&"+pname);
            // 4.得到用户
            BehaviorRecordSync behaviorRecordSync = (BehaviorRecordSync) args[0];
            if (behaviorRecordSync == null) {
                throw new PrivilegeException();
            }
        }
        BehaviorRecordSync behaviorRecordSync=(BehaviorRecordSync)args[0];
        System.out.println("*********************"+behaviorRecordSync.getCode());
        Object o=method.invoke(behaviorRecordSyncMapperService,args);
        System.out.println("绑定之后做的事情");
        return o;
    }
}
