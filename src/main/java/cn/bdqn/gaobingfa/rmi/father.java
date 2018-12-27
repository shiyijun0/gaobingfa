package cn.bdqn.gaobingfa.rmi;

import java.io.Serializable;

public class father implements Serializable {
    private String name;
    private  Integer age;

    public father(Integer age) {
        this.age = age;
    }

    public father(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public father() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public  String string(String name){
        System.out.println("进入方法名称"+name);
        return  name;
    }
}
