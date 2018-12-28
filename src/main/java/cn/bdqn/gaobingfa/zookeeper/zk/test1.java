package cn.bdqn.gaobingfa.zookeeper.zk;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test1 implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getName().compareTo(o2.getName())>0)
        return 1;
        else
            return -1;
    }

  static   Comparator<Student> comparator=new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getName().compareTo(o2.getName())>0)
                return 1;
            else
                return -1;
        }
    };

    public static void main(String[] args) {
        test1 test1=new test1();

        Comparator<Student> studentComparator=(Student o1,Student o2)->{
            if(o1.getName().compareTo(o2.getName())>0)
                return 1;
            else
                return -1;
        };


        Student student=new Student(20,"d");
        Student student1=new Student(3,"a");
        Student student2=new Student(6,"b");
        List<Student> studentlist= Arrays.asList(student,student1,student2);
        for (Student s:studentlist){
            System.out.print(s.getName()+"\t");
        }
        System.out.println();
        Collections.sort(studentlist,studentComparator);
        for (Student s:studentlist){
            System.out.print(s.getName()+"\t");
        }
    }
}
