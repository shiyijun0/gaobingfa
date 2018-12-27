package cn.bdqn.gaobingfa.rmi;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestRefalect {
    public static void main(String[] args)  throws Exception{
        father father=new father();
        father father1=new father();
        System.out.println(father==father1);

        Class  cla=Class.forName("cn.bdqn.gaobingfa.rmi.father");
        Class  cla1=Class.forName("cn.bdqn.gaobingfa.rmi.father");
        father father3=(father)cla.newInstance();
        father father4=(father)cla.newInstance();
        father father2=(father)cla.getConstructor(Integer.class).newInstance(23);
        System.out.println(father2.getAge());
        System.out.println(cla==cla1);
        System.out.println(father3==father4);
        System.out.println(cla==father2.getClass());

        Method method=cla.getDeclaredMethod("string", String.class);
        method.invoke(father3,"史蒂夫");
        Field field=cla.getDeclaredField("name");
        field.setAccessible(true);
        field.set(father3,"是的方法");
        System.out.println( father3.getName());

        Method[] method1=cla.getMethods();



    }
}
