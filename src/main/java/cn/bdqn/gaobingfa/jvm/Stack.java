package cn.bdqn.gaobingfa.jvm;

public class Stack {
    private String name;
    private  int id;
    private static class NewStack{
        private String name;
        private Stack stack;
    }

    private static Stack pringt(){
        Stack u = new Stack();
        u.id = 5;
        u.name = "mark";
      //  System.out.println(u);
        return u;


    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for(int i=0;i<100000000;i++) {
            pringt();
        }
        long e = System.currentTimeMillis();
        System.out.println((e-b)+"ms");
    }
}
