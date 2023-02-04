package com.learning.java8.learning.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * transferFrom
 */
public class FileChannelDemo3 {

    public static void main(String[] args) throws IOException {
        // 打开filechannel
        RandomAccessFile accessFileA = new RandomAccessFile("D:\\develop\\channel01.txt", "rw");
        FileChannel channelA = accessFileA.getChannel();

        // 打开filechannel
        RandomAccessFile accessFileB = new RandomAccessFile("D:\\develop\\channel02.txt", "rw");
        FileChannel channelB = accessFileB.getChannel();

        long position = 0;
        long count = channelA.size();
        channelB.transferFrom(channelA, position, count);

        accessFileA.close();
        accessFileB.close();

    }
}
