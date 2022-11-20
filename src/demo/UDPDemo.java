package demo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/9/27
 * @time 5:58 PM
 */
public class UDPDemo {
    public static void main(String[] args) throws IOException {
        //1. 建立 一个 Socket
        DatagramSocket socket = new DatagramSocket();


        //2. 发送给谁 ？

        InetAddress localhost = InetAddress.getByName("10.3.210.1");
        int port = 9289;


        //3. 建立个 数据包
        String msg = "你好啊，服务器！";
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length,localhost,port);

        //4. 发送个 数据包
        socket.send(packet);

        //5. 关闭连接
        socket.close();
    }

}
