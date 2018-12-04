package cn.bdqn.gaobingfa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/guard?useUnicode=true&characterEncoding=utf8" ;
        String username = "root" ;
        String password = "root" ;
        Class.forName("com.mysql.jdbc.Driver") ;
        Connection connection= DriverManager.getConnection(url,username,password);
        Statement statement=connection.createStatement();
      ResultSet resultSet= statement.executeQuery("SELECT * FROM book ");
            while (resultSet.next()){
                System.out.println(resultSet.getString("title"));
            }

            if(resultSet!=null){
                resultSet.close();
            }
            if(statement!=null){
                statement.close();
            }

            if(connection!=null){
                connection.close();
            }

    }
}
