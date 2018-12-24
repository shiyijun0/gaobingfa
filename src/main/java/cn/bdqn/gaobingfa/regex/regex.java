package cn.bdqn.gaobingfa.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("/a/b/[a-z]{1,}");
        String s="/a/b/cddf/gh";
        Matcher matcher=pattern.matcher(s);
        System.out.println(matcher.matches());
        System.out.println("****************");
        // 要验证的字符串
        String str = "baike.xsoftlab.net";
        // 正则表达式规则
        String regEx = "baike.*";
        // 编译正则表达式
        Pattern pattern1 = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(str);
        // 查找字符串中是否有匹配正则表达式的字符/字符串
        boolean rs = matcher1.find();
        System.out.println(rs);

        System.out.println("************2******");

        //一个正则表达式无法判断同时包含字母与数字，所以用两个正则表达式
        //判断设置的密码（要求至少6位，必须包含数字与字母）：

        String pass = "asdf12sa";//密码

        String regexNum = "[0-9]{1,}";//或"[0-9]+"

        String regexLetter ="[a-zA-Z]{1,}";//同上

        Pattern pattern2 = Pattern.compile(regexNum);

        Pattern pattern3 = Pattern.compile(regexLetter);

        Matcher m1 = pattern2.matcher(pass);

        Matcher m2 = pattern3.matcher(pass);

        System.out.println(m1.find()+"*********"+m2.find());

        if(m1.find()&&m2.find()){

//密码格式合格


        }

    }
}
