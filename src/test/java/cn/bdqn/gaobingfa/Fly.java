package cn.bdqn.gaobingfa;

public interface Fly {
    int sh=9;
    void fly();

  default   void sd(String d){
        System.out.println("*************"+d);
    }

    enum en{
        SCUSS(1,"成功"),
        FAILAD(-1,"失败");
        private String msg;
        private int code;

        en( int code,String msg) {
            this.msg = msg;
            this.code = code;
        }
    }
}
