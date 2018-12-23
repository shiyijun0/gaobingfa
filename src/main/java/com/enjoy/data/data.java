package com.enjoy.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class data {
    private String url="jdbc:mysql://39.105.169.182:3306/test?useUnicode=true&characterEncoding=utf8";
    private String user="root";
    private String password="root";
    int i=0;
    String str="INSERT INTO `product_info` VALUES";
    public  void contextLoads() throws Exception {
        BufferedReader bufferedReader=new BufferedReader(new FileReader("D:\\product_info.sql"));
        Connection connection=DriverManager.getConnection(url,user,password);
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("********"+localDateTime);
        connection.setAutoCommit(false);
        bufferedReader.lines().forEach(sql->{
            str=str+sql.split("VALUES")[1].replace(";",",");
            if((i%2000)!=0 && i<2097152){
                i++;
            }else {
                i++;
                str=str.substring(0,str.length()-1);

                try {
                    PreparedStatement prp=connection.prepareStatement(str);
                    prp.execute();
                    str="INSERT INTO `product_info` VALUES";
                    connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        });
        bufferedReader.close();
        connection.close();

        LocalDateTime localDateTime1=LocalDateTime.now();
        System.out.println("****1****"+localDateTime1);
    }

    public void test1() throws Exception{
        BufferedReader bufferedReader=new BufferedReader(new FileReader("D:\\product_info.sql"));
        Connection connection=DriverManager.getConnection(url,user,password);
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("********"+localDateTime);
        bufferedReader.lines().forEach(sql->{

            try {
                PreparedStatement prp=connection.prepareStatement(sql);
                prp.executeUpdate();
                prp.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        });
        bufferedReader.close();
        connection.close();

        LocalDateTime localDateTime1=LocalDateTime.now();
        System.out.println("****1****"+localDateTime1);
    }


    public static void main(String[] args)   {
        data data=new data();

        try {
            data.contextLoads();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
