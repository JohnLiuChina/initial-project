package com.learning.java8.learning.nio.buffer;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class BufferDemo2 {

    /**
     * 缓冲区分片
     */
    @Test
    public void b01() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        buffer.position(3);
        buffer.limit(7);

        ByteBuffer slice = buffer.slice();
        for (int i = 0; i < slice.capacity(); i++) {
            slice.put(i, (byte) (slice.get(i) * 10));
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
    }


    /**
     * 只读缓冲区
     */
    @Test
    public void readonlybuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        // 创建只读缓冲区
        ByteBuffer buffer1 = buffer.asReadOnlyBuffer();

        // 修改原缓冲区内容
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i, (byte) (buffer.get(i) * 10));
        }

        System.out.println(buffer1.position());
        buffer1.position(0);
        buffer1.limit(buffer1.capacity());
        while (buffer1.hasRemaining()) {
            System.out.println(buffer1.get());
        }
    }

    // 直接缓冲区
    @Test
    public void direct() throws IOException {
        String infile = "D:\\develop\\channel.txt";
        String outfile = "D:\\develop\\channel04.txt";
        FileInputStream inputStream = new FileInputStream(infile);
        FileChannel inputChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream(outfile);
        FileChannel outputChannel = outputStream.getChannel();

        // 创建直接缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            buffer.clear();
            int read = inputChannel.read(buffer);
            if(read == -1) {
                break;
            }
            buffer.flip();
            outputChannel.write(buffer);
        }

        inputStream.close();
        outputStream.close();
    }

    // 内存映射IO
    @Test
    public void mem() throws IOException {
        int start = 0;
        int size = 1024;
        RandomAccessFile accessFile = new RandomAccessFile("D:\\develop\\channel05.txt", "rw");
        FileChannel channel = accessFile.getChannel();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, start, size);

        mappedByteBuffer.put(0, (byte) 97);
        mappedByteBuffer.put(1023, (byte) 122);
        accessFile.close();
    }

}
