package com.learning.java8.test.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 5555);

        if(!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("客户端正在连接中，请耐心等待");
            }
        }

        ByteBuffer byteBuffer = ByteBuffer.wrap("mikechen的互联网架构".getBytes());
        socketChannel.write(byteBuffer);
        socketChannel.close();
    }

}
