package cn.bdqn.gaobingfa.TCP;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket=new ServerSocket(8888);
        System.out.println("服务器已启动，端口为8888");
        while (true){
            //等待客户端建立连接
            Socket socket=serverSocket.accept();
                //读取客户端内容
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String buffer=null;
           // while ((buffer=bufferedReader.readLine())!=null && !(buffer=bufferedReader.readLine()).equalsIgnoreCase("")){
            while ((buffer=bufferedReader.readLine())!=null ){
                System.out.println("读取客户端内容******："+buffer);
            }
           //服务端响应客户端内容
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //模拟请求头信息
            bufferedWriter.write("HTTP/1.1 200 OK \r\n Content-Type:text/html \r\n charset=UTF-8\r\n\r\n");
            bufferedWriter.write("<html><head><title>http请求</title></head><body><h1>这是一个HTTP请求</h1></body></html>");
            //仅仅放入缓存，刷新输出流，使得数据立马发送
            bufferedWriter.flush();
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
           // serverSocket.close();

        }
    }

}
