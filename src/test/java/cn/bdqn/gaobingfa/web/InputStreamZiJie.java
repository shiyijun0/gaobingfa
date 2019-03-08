package cn.bdqn.gaobingfa.web;

import java.io.*;

public class InputStreamZiJie {
    public static void main(String[] args) throws Exception{

        File file=new File("F:\\zhihui\\github\\gaobingfa\\src\\main\\resources\\rj.txt");
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(file),"utf-8");
        outputStreamWriter.write("地方");
        //outputStreamWriter.write("22222地方法规规范");
        outputStreamWriter.close();

        InputStream inputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
       /* byte b[]=new byte[10];
        int i=inputStream.read(b);
        while (i!=-1){
            System.out.print(i+"\t");
            System.out.println();
            System.out.println(b);
            i=inputStream.read();
            System.out.println(i);
        }

        for (byte c:b){
            System.out.print(c+"\t");
        }*/

       StringBuffer stringBuffer=new StringBuffer();
       char[] chars=new char[2];
       int d=-1;
       while ((d=inputStreamReader.read(chars))!=-1){
           stringBuffer.append(chars,0,chars.length);
        }
       // AnnotationConfigApplicationContext
        System.out.println(stringBuffer.toString()+"*******888888888");
       // Writer writer=new FileWriter(file);
       /* BufferedWriter bufferedWriter=new BufferedWriter(writer);
        bufferedWriter.write("是的方法");
        bufferedWriter.newLine();
        bufferedWriter.write("4566");
        bufferedWriter.write("非凡哥哈哈哈");
        bufferedWriter.flush();
        bufferedWriter.close();
        writer.close();*/

    }
}
