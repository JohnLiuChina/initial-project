package com.learning.java8.learning.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
        socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(1);
        int read = socketChannel.read(buffer);
        while (read != -1) {
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            read = socketChannel.read(buffer);
        }
        socketChannel.close();
        System.out.println("over");

    }

}
