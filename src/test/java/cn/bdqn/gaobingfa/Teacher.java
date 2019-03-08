package cn.bdqn.gaobingfa;

public class Teacher {
    private String name;
    private  int age;

    public Teacher(){
        System.out.println("*****");
        this.age=20;

    }

    public Teacher(String name,int age){
        System.out.println("*****");
        this.age=20;
    }

    public String string(String name){
        return name;
    }
    public String string1(String name,int age){
        return name+age;
    }

    public String string2(String name,int age){
        //this.("df",30);
       this.string1("df",30);
        return name;
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
}
