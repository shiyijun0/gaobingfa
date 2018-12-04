package cn.bdqn.gaobingfa.jdbc;


import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class file {
    public static void main(String[] args) {
        System.out.println(file2.class.getName());
        String string="messages.properties";
        char [] ch=new char[1024];

        try {
            InputStream inputStream= Resources.getResourceAsStream(string);
            InputStream stream=file.class.getClassLoader().getResourceAsStream(string);

            /*int i=inputStream.read();
            while (i!=-1){
                System.out.println(i);
               i= inputStream.read();
            }*/

            Reader reader=Resources.getResourceAsReader(string);

            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            int j=0;
            while ((j=inputStreamReader.read(ch))!=-1){
                System.out.print((char)j);

                System.out.println(new String(ch,0,j));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("*****"+ch.length);
        }
    }
}
