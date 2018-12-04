package cn.bdqn.gaobingfa.jdbc;

import org.apache.ibatis.io.Resources;

import java.io.Reader;
import java.util.Properties;

public class file2 {
    final static  String string="messages.properties";

    public static void main(String[] args) throws Exception {
        //读入属性文件
        Reader reader=null;
        reader= Resources.getResourceAsReader(string);
        Properties properties=new Properties();
        properties.load(reader);
        //properties.setProperty("username",decc)
        System.out.println(properties.getProperty("username.is.null"));
        System.out.println(properties.getProperty("username"));


    }
}
