package cn.bdqn.gaobingfa;

public enum Enu {
  //  RED, GREEN, BLANK, YELLOW;
    SCUSS(1,"成功"),
    FAILAD(-1,"失败");
    public String msg;
    public int code;

    Enu( int code,String msg) {
        this.code = code;
        this.msg = msg;

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
