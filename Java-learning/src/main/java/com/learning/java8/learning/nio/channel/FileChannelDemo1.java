package com.learning.java8.learning.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo1 {

    public static void main(String[] args) throws IOException {
        // 创建channel
        RandomAccessFile accessFile = new RandomAccessFile("D:\\develop\\channel.txt", "rw");
        FileChannel channel = accessFile.getChannel();

        // 创建buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

        // 读取数据到buffer中
        int bytesRead = channel.read(byteBuffer);
        while (bytesRead != -1) {
            System.out.println("read:" + bytesRead);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
            bytesRead = channel.read(byteBuffer);
        }
        accessFile.close();
    }

}
