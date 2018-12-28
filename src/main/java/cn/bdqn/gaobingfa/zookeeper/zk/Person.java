package cn.bdqn.gaobingfa.zookeeper.zk;

import java.io.Serializable;

public class Person implements Serializable,Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Person o) {
        if((this.name.compareTo(o.name))>0){
            return 1;
        } else {
            return -1;
        }

    }
}
