package com.learning.java8.learning.nio.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class ChatServer {

    public void startServer() throws Exception {
        // 创建selector选择器
        Selector selector = Selector.open();
        // 创建serversocketchannel通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 绑定端口
        channel.bind(new InetSocketAddress(8080));
        // 设置非阻塞模式
        channel.configureBlocking(false);
        // 注册到selector上
        channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Chat server started.");
        // 循环，等待新连接接入

        for (;;) {
            int select = selector.select();
            if (select == 0) {
                Thread.sleep(1000);
                continue;
            }
            // 获取可用channels
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();

                iterator.remove();

                // 根据就绪状态，调用对应方法实现具体业务操作
                if (next.isAcceptable()) {
                    acceptOperator(channel, selector);
                } else if (next.isReadable()) {
                    readOperator(next, selector);
                }
            }
        }
    }

    /**
     * 处理可读
     * @param selectionKey
     * @param selector
     */
    private void readOperator(SelectionKey selectionKey, Selector selector) throws IOException {
        // 从selectionKey中获取已经就绪的通道
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 循环读取客户端消息
        int read = channel.read(buffer);
        String message = "";
        while (read > 0) {
            buffer.flip();
            message += Charset.forName("UTF-8").decode(buffer);
            buffer.clear();
            read = channel.read(buffer);
        }
        // 将channel再次注册到选择器上，监听可读状态'
        channel.register(selector, SelectionKey.OP_READ);
        // 广播消息
        if (message.length() > 0) {
            System.out.println("待广播消息：" + message);
            castOtherClient(message, selector, channel);
        }
    }

    private void castOtherClient(String message, Selector selector, SocketChannel channel) throws IOException {
        // 获取所有已经接入的客户端
        Set<SelectionKey> keys = selector.keys();
        // 广播消息
        for (SelectionKey key : keys) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != channel) {
                ((SocketChannel) targetChannel).write(Charset.forName("UTF-8").encode(message));
            }
        }
    }

    private void acceptOperator(ServerSocketChannel channel, Selector selector) throws IOException {
        // 创建SocketChannel
        SocketChannel accept = channel.accept();
        // 把socketChannel设置非阻塞
        accept.configureBlocking(false);
        // 注册到selector上，监听可读状态
        accept.register(selector, SelectionKey.OP_READ);
        // 给客户端回复信息
        accept.write(Charset.forName("UTF-8").encode("欢迎进入聊天"));
    }

    public static void main(String[] args) {
        try {
            new ChatServer().startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
