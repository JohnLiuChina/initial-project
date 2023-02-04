package com.learning.java8.learning.nio.selector;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo2 {

    /**
     * 客户端代码
     * @throws Exception
     */
    @Test
    public void clientDemo() throws Exception {
        // 获取通道，绑定主机、端口号
        SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        // 切换到非阻塞模式
        channel.configureBlocking(false);
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 写入buffer数据
        buffer.put(new Date().toString().getBytes());
        // 模式切换
        buffer.flip();
        // 写入通道
        channel.write(buffer);
        // 关闭通道
        channel.close();
    }

    /**
     * 服务端代码
     * @throws Exception
     */
    @Test
    public void serverDemo() throws Exception {
        // 获取服务端通道
        ServerSocketChannel channel = ServerSocketChannel.open();
        // 设置非阻塞
        channel.configureBlocking(false);
        // 创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 绑定端口号
        channel.bind(new InetSocketAddress(9999));
        // 获取selector选择器
        Selector selector = Selector.open();
        // 注册通道到选择器上，进行监听
        channel.register(selector, SelectionKey.OP_ACCEPT);
        // 选择器进行轮询，对就绪状态的通道进行后续操作
        while (true) {
            int select = selector.selectNow();
            if (select <= 0) {
                System.out.println("等待新连接...");
                Thread.sleep(2000);
                continue;
            }
            System.out.println("select:" + select);
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey next = iterator.next();
                if (next.isAcceptable()) {
                    // 获取连接
                    SocketChannel socketChannel = channel.accept();
                    // 切换到非阻塞
                    socketChannel.configureBlocking(false);
                    // 注册
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if(next.isReadable()) {
                    SocketChannel readChannel = (SocketChannel) next.channel();
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    // 读取数据
                    int length = 0;
                    while ((length = readChannel.read(readBuffer)) > 0) {
                        readBuffer.flip();
                        System.out.println(new String(readBuffer.array(), 0, length));
                        readBuffer.clear();
                    }
                    readChannel.close();
                }

                iterator.remove();
            }
        }

    }

}
