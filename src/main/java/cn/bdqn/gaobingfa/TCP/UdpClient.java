package cn.bdqn.gaobingfa.TCP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket datagramSocket=new DatagramSocket();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            //转成byte
            byte[] bytes=line.getBytes();
            DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),10005);
            datagramSocket.send(datagramPacket);//发送数据包
            if("88".equals(line)){
                break;//当输入88时结束发送
            }

        }

        datagramSocket.close();
    }
}
