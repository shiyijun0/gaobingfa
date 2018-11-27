package cn.bdqn.gaobingfa.aop;

public class StaicProxy implements StudentService {
    private StudentService studentService;
    public StaicProxy(StudentService studentService) {
        this.studentService=studentService;
    }

    @Override
    public void print() {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
        studentService.print();
        System.out.println("事务处理之后");
    }

    @Override
    public String string(String name) {
        System.out.println("事务处理之前");
        // 调用委托类的方法;
      String name1=  studentService.string(name);
        System.out.println("事务处理之后");
        return name1;
    }

    public static void main(String[] args) {
        StaicProxy staicProxy=new StaicProxy(new StudentServiceImpl());

        staicProxy.print();
    }
}
