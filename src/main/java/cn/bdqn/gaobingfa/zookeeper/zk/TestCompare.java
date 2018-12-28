package cn.bdqn.gaobingfa.zookeeper.zk;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestCompare {
    public static void main(String[] args) {
        String[] arr=new String[]{"c","a","b"};
        Collections.sort(Arrays.asList(arr));
       for (String b:arr){
           System.out.print(b+"\t");
       }
        System.out.println("********");
        List<String> list=Arrays.asList("f","g","e");
       String[] o=(String[])list.toArray();
       for (String c:o){
           System.out.print(c+"\t");
       }

       Person person=new Person("d",3);
        Person person1=new Person("a",3);
        Person person2=new Person("b",3);
        List<Person> personList=Arrays.asList(person,person1,person2);
        System.out.println("********");
        for (Person p:personList){
            System.out.print(p.getName()+"\t");
        }

        Collections.sort(personList);
        System.out.println();
        for (Person p:personList){
            System.out.print(p.getName()+"\t");
        }




    }




}
