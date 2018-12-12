package cn.bdqn.gaobingfa.Util;

public class ResultData {
    /**
     * 返回成功带参数
     * @param object
     * @return
     */
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success(Integer code ,Object object){
        Result result = new Result();
        result.setCode(code);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    /**
     * 基本信息
     * @param object
     * @return
     */
    public static Result info(Object object,int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }


    /**
     * 定义错误返回格式
     * @param code
     * @param msg
     * @return
     */
    public static Result error(Integer code , String msg){
        Result resultObject = new Result();
        resultObject.setCode(code);
        resultObject.setMsg(msg);
        return resultObject;
    }
}
