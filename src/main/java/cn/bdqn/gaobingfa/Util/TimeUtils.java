package cn.bdqn.gaobingfa.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

    /**
     * 把当前时间格式为指定格式
     */
    public  static  String TimeForString(){
        //获得当前时间
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format = ldt.format(dtf);
        System.out.println(format);
        return  format;
    }

    /**
     * 把指定字符串格式化为日期
     */
    public static LocalDateTime DateforString(String str){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(str, dtf);
        System.out.println(parse);
        return  parse;
    }
}
