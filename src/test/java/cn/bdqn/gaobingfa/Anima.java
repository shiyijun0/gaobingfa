package cn.bdqn.gaobingfa;

@Comp
public  class Anima {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static  double d(double a, double b){
        return a+b;
    }

    public   double d1(double a,double b){
        return a+b;
    }

    public final static     double d2(double a,double b){
        return a+b;
    }

    static {
        System.out.println("*******动物物种***");
    }

    public Anima() {
        System.out.println("*******构造器动物物种***");
    }

public   enum en{
        SCUSS(1,"成功"),
        FAILAD(-1,"失败");
        public String msg;
        public int code;

        en( int code,String msg) {
            this.msg = msg;
            this.code = code;
        }
    }
}
