package com.learning.java8.learning.nio.chat.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ChatClient {

    private String name;

    public ChatClient(String name) {
        this.name = name;
    }

    public void startClient() throws IOException {
        // 连接服务端
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8080));
        // 接收
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_READ);
        new Thread(new ReceiveWorker(selector)).start();
        // 发送
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            if (msg.length() > 0) {
                channel.write(Charset.forName("UTF-8").encode(name + ":" + msg));
            }
        }
    }

}
