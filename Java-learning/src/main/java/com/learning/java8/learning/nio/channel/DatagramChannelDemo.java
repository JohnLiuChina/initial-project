package com.learning.java8.learning.nio.channel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class DatagramChannelDemo {

    // SEND datagram
    @Test
    public void sendDatagram() throws IOException, InterruptedException {
        // 打开datagram channel
        DatagramChannel sendChannel = DatagramChannel.open();
        InetSocketAddress sendAddress = new InetSocketAddress("127.0.0.1", 9999);

        // 发送
        while (true) {
            sendChannel.send(ByteBuffer.wrap("打send datagram message".getBytes("UTF-8")), sendAddress);
            System.out.println("完成发送");
            Thread.sleep(1000);
        }
    }

    // receive
    @Test
    public void receiveDatagram() throws IOException, InterruptedException {
        // 打开datagram channel
        DatagramChannel receiveChannel = DatagramChannel.open();
        InetSocketAddress receiveAddress = new InetSocketAddress("127.0.0.1",9999);
        receiveChannel.bind(receiveAddress);

        // 创建buffer
        ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

        while(true) {
            receiveBuffer.clear();

            SocketAddress receive = receiveChannel.receive(receiveBuffer);
            receiveBuffer.flip();
            System.out.println(receive);
            System.out.println(Charset.forName("UTF-8").decode(receiveBuffer));
            Thread.sleep(1000);
        }
    }

    // connect后使用read和write
    @Test
    public void testConnect() throws IOException {
        // 打开datagram channel
        DatagramChannel connectChannel = DatagramChannel.open();
        // bind port
        InetSocketAddress receiveAddress = new InetSocketAddress("127.0.0.1",9999);
        connectChannel.bind(receiveAddress);

        // connect
        connectChannel.connect(receiveAddress);

        // write
        connectChannel.write(ByteBuffer.wrap("打send datagram message".getBytes("UTF-8")));

        // buffer
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);

        while (true) {
            readBuffer.clear();
            connectChannel.read(readBuffer);
            readBuffer.flip();
            System.out.println(Charset.forName("UTF-8").decode(readBuffer));
        }
    }

}
