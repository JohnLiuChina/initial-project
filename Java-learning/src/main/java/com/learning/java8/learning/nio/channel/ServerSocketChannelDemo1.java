package com.learning.java8.learning.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 8888;
        ByteBuffer buffer = ByteBuffer.wrap("nio helloworld".getBytes());

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(port));
        channel.configureBlocking(false); // 设置为非阻塞模式

        while (true) {
            System.out.println("waiting for connections");
            // 监听新连接，此处如果是阻塞模式则会等到出现新连接为止
            SocketChannel accept = channel.accept();
            if (accept == null) {
                System.out.println("null");
                Thread.sleep(2000);
            } else {
                System.out.println("Incoming connection from:" + accept.socket().getRemoteSocketAddress());
                buffer.rewind(); // rewind重置position位置，但是limit位置不变，可以重新读出buffer数据
                accept.write(buffer);
                accept.close();
            }
        }
    }
}
