package cn.bdqn.gaobingfa;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestSpring {

    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            System.out.println("********");
        }
    };

    public static void main(String[] args) throws Exception {

        Vector vector=new Vector(5);
        vector.add(51);
        vector.add("rgf1");
        vector.add(5);
        vector.add("rgf");
        vector.add(52);
        vector.add("rgf2");
        int i=0;
        for (Object o:vector){
            System.out.println(vector.get(i));
            i++;
        }
        System.out.println("**********");
        Stack stack=new Stack();
        System.out.println(stack.empty());
        stack.push("的非官方");
        stack.push("dfg");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
      //  System.out.println(stack.pop());
      //  System.out.println(stack.peek());
        List list= Collections.synchronizedList(new ArrayList<>());

     //   File file=new File("F:\\项目笔记\\springboot\\基础笔记\\syj.txt");
        InputStream stream=new FileInputStream("F:\\项目笔记\\springboot\\基础笔记\\syj.txt");
        Properties properties=new Properties();
        properties.load(stream);
        System.out.println(properties);
        System.out.println("用户名:"+properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
        System.out.println("用户名:"+properties.getProperty("username1"));
        System.out.println(properties.getProperty("password1"));
        /*int index=-1;
        byte[] bytes=new byte[100];

        while ((index=stream.read(bytes))!=-1){
          //  System.out.print(index+"\t");
            System.out.print(new String(bytes)+"\t");

        }*/
        InetAddress inetAddress=InetAddress.getByName("lulh-PC");
        System.out.println(inetAddress.toString());
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getHostAddress());

        String name="认定法";
        String code= URLEncoder.encode(name,"UTF-8");
        System.out.println(code);
        String code1= URLDecoder.decode(code,"UTF-8");
        System.out.println(code1);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
      String da=  simpleDateFormat.format(date);
        System.out.println(da+"*******");
        Date date1=simpleDateFormat.parse(da);
        System.out.println(date1);

    }
}
