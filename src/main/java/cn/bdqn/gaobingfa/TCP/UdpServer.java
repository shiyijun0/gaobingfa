package cn.bdqn.gaobingfa.TCP;


import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpServer {
    public static void main(String[] args) throws Exception {
        //创建一个数据包实例，棒定本机和端口
        DatagramSocket datagramSocket=new DatagramSocket(10005);
        byte[] bytes=new byte[1024];
        //以建立一个空数组来创建datagarmpacker，,这个对象用来接收实例包中数据
        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length);
        while (true){
            System.out.println("无数循环*************");
            datagramSocket.receive(datagramPacket);
            //获取接收的数据
            byte[] data=datagramPacket.getData();
            String str=new String(data,0,datagramPacket.getLength());
            if("88".equals(str)){
                break;
            }
            System.out.println("接收到的数据为*********："+str);

        }
        datagramSocket.close();

    }
}
