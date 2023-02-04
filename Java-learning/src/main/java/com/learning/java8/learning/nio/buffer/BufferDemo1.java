package com.learning.java8.learning.nio.buffer;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo1 {

    @Test
    public void buffer01() throws IOException {
        // 打开filechannel
        RandomAccessFile file = new RandomAccessFile("D:\\develop\\channel.txt", "rw");
        FileChannel channel = file.getChannel();

        // 创建BUFFER
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读
        int read = channel.read(buffer);
        while (read != -1) {
            buffer.flip();

            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            channel.read(buffer);

        }

        file.close();

    }

    @Test
    public void intBuffer() {
        // 创建buffer
        IntBuffer intBuffer = IntBuffer.allocate(8);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            int j = 2 * (i + 1);
            intBuffer.put(j);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(" " + intBuffer.get());
        }


    }


}
