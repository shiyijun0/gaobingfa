package cn.bdqn.gaobingfa.jdbc;

import java.lang.reflect.Method;

public class reflectTest {
    public static void main(String[] args) throws Exception{
        Class class1=Class.forName(reflect.class.getName());
        Object object=class1.newInstance();
      Method method=  class1.getMethod("re",String.class);
        System.out.println(method.invoke(object,"十一局"));
    }
}
