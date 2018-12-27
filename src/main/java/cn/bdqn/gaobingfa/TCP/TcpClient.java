package cn.bdqn.gaobingfa.TCP;

import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws Exception {
        String msg="hello , 13号技师";
        //创建一个sockt 跟本机8888进行连接
        Socket socket=new Socket("127.0.0.1",8888);
        //使用socket 进行writer进行写数据
        PrintWriter printWriter=new PrintWriter(socket.getOutputStream());
        //发送数据
        printWriter.print(msg);
        //刷新一下使得服务接收到数据
        printWriter.flush();
        socket.close();

    }
}
