package cn.bdqn.gaobingfa;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class TestDog {

    public static void main(String[] args) throws Exception {
        Anima anima=new Dog();
        anima=new Dog();
        System.out.println("******");
        Anima anima1=new Dog();
        System.out.println("*********");
        Fly fly=new Dog();
        fly.fly();
        fly.sd("是否");
        Anima anima2=new Anima();
      int code= Enu.FAILAD.code;
      int code1=Enu.FAILAD.getCode();
        System.out.println(code+"********"+code1);
      //  System.out.println(Enu.);
       int d= Anima.en.FAILAD.code;
       Class cla=Class.forName("cn.bdqn.gaobingfa.Anima");
       Anima anima3=(Anima)cla.newInstance();
        Annotation[] annotation= cla.getAnnotations();
        System.out.println( cla.isAnnotation());
        for (Annotation annotation1:annotation){
            System.out.println("*********"+annotation1.toString());

        }
       Comp  comp=(Comp) cla.getAnnotation(Comp.class);
        System.out.println(comp.name());

        System.out.println();

        Field field=cla.getDeclaredField("name");
        field.setAccessible(true);
        field.set(anima3,"水电费");
        System.out.println(anima3.getName());


    }
}
