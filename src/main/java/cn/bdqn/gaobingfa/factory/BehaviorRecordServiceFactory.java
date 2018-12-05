package cn.bdqn.gaobingfa.factory;

import cn.bdqn.gaobingfa.annotation.PrivilegeInfo;
import cn.bdqn.gaobingfa.entity.BehaviorRecordSync;
import cn.bdqn.gaobingfa.exception.PrivilegeException;
import cn.bdqn.gaobingfa.service.BehaviorRecordSyncMapperService;
import cn.bdqn.gaobingfa.service.BehaviorRecordSyncMapperServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class BehaviorRecordServiceFactory  {
	private static BehaviorRecordSyncMapperService service = new BehaviorRecordSyncMapperServiceImpl();

	public static BehaviorRecordSyncMapperService getInstance() {

		return (BehaviorRecordSyncMapperService) Proxy.newProxyInstance(service.getClass()
				.getClassLoader(), service.getClass().getInterfaces(),
				new InvocationHandler() {

					public Object invoke(Object proxy, Method method,
							Object[] args) throws IllegalAccessException,
							IllegalArgumentException, InvocationTargetException {
						// 1.判断是否有注解
						if (method.isAnnotationPresent(PrivilegeInfo.class)) {
							// 2。得到注册对象
							PrivilegeInfo pif = method
									.getAnnotation(PrivilegeInfo.class);
							// 3.得到权限名称
							String pname = pif.value();
							System.out.println("*********"+pname);
							// 4.得到用户
							BehaviorRecordSync user = (BehaviorRecordSync) args[0];

							if (user == null) {
								throw new PrivilegeException();
							}
							/*// 5.根据用户查询是否具有权限
							PrivilegeDao pdao = new PrivilegeDao();
							if (!pdao.checkPrivilege(user.getRole(), pname)) {
								throw new PrivilegeException(); // 抛出权限不足异常

							}*/

						}

						return method.invoke(service, args);

					}
				});

	}
}
