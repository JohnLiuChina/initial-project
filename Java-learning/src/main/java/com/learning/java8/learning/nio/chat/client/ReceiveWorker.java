package com.learning.java8.learning.nio.chat.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class ReceiveWorker implements Runnable {

    private Selector selector;

    public ReceiveWorker(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
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
                    if (next.isReadable()) {
                        readOperator(next, selector);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        System.out.println(message);
        // 将channel再次注册到选择器上，监听可读状态'
        channel.register(selector, SelectionKey.OP_READ);
    }

}
