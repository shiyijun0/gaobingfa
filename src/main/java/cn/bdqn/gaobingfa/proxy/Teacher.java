package cn.bdqn.gaobingfa.proxy;

public class Teacher implements Schoole {

    @Override
    public String tea(String s) {
        System.out.println("老师说的说的");
        return s;
    }
}
