package cn.bdqn.gaobingfa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DataSource {
private String url="jdbc:mysql://39.105.169.182:3306/test?useUnicode=true&characterEncoding=utf8";
private String user="root";
private String password="root";
int i=0;
String str="INSERT INTO `product_info` VALUES";
    @Test
    public void contextLoads() throws Exception {
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

    @Test
    public void test() throws Exception{
        BufferedReader bufferedReader=new BufferedReader(new FileReader("D:\\product_info.sql"));
        Connection connection=DriverManager.getConnection(url,user,password);
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println("********"+localDateTime);
        connection.setAutoCommit(false);
        bufferedReader.lines().forEach(sql->{

                try {
                    PreparedStatement prp=connection.prepareStatement(sql);
                    prp.addBatch();
                    if((i%2000)!=0 && i<2097152){
                        i++;
                    }else {
                        prp.executeBatch();
                        connection.commit();
                        i=0;
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

        });
        bufferedReader.close();
        connection.close();

        LocalDateTime localDateTime1=LocalDateTime.now();
        System.out.println("****1****"+localDateTime1);
    }
}
