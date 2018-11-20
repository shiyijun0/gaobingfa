package cn.bdqn.gaobingfa.redis;

public class TestMyrun {
    public static void main(String[] args) {
        Myrun myrun=new Myrun();
        for(int i=0;i<40;i++){
      Thread s=new Thread(myrun,"线程A");
      s.start();
            Thread s1=new Thread(myrun,"线程B");
            s1.start();
            Thread s2=new Thread(myrun,"线程C");
            s2.start();
            Thread s3=new Thread(myrun,"线程D");
            s3.start();
        }
    }

}
