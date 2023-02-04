package com.learning.java8.learning.nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorDemo1 {

    public static void main(String[] args) throws IOException {
        // 创建selector
        Selector selector = Selector.open();

        // 创建channel
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(9999));

        // 配置channel为非阻塞模式
        channel.configureBlocking(false);

        channel.register(selector, SelectionKey.OP_ACCEPT);

        // 获取selectionKeys
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while (iterator.hasNext()) {
            SelectionKey next = iterator.next();
            if (next.isAcceptable()) {

            } else if (next.isWritable()) {

            } else if (next.isConnectable()) {

            } else if (next.isReadable()) {

            }
            iterator.remove();
        }
    }
}
