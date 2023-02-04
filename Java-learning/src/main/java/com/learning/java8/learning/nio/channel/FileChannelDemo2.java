package com.learning.java8.learning.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo2 {

    public static void main(String[] args) throws IOException {
        // 打开filechannel
        RandomAccessFile accessFile = new RandomAccessFile("D:\\develop\\channel01.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        // 创建buffer对象
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 写入数据
        String newData = "dsfjnklc;dslk;";
        buffer.clear();
        buffer.put(newData.getBytes());
        buffer.flip();

        // FileChannel完成最后实现
        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }

        accessFile.close();
    }
}
