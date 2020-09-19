package com.why.bufferAndChannelCopyFiles;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ：why
 * @date ：Created in 2020/5/5 19:20
 * @description：
 * @version:
 */
public class Demo {
    public static void main(String[] args) {
//        copyNIO();
    }

    /**
     * 一般方法
     */
    public static void copyNormal() {
        try (FileInputStream fileInputStream = new FileInputStream(new File("E:\\GitHubDesktopSetup.exe"));
             FileOutputStream fileOutputStream = new FileOutputStream(new File("aaa.exe"))) {
            byte[] buffer = new byte[1024 * 10];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * NIO方法
     */
    public static void copyNIO() {
        try (RandomAccessFile source = new RandomAccessFile("E:\\GitHubDesktopSetup.exe", "r");
             RandomAccessFile target = new RandomAccessFile("GitHubDesktopSetup.exe", "rw");
             FileChannel in = source.getChannel();
             FileChannel out = target.getChannel()) {
            long size = in.size();
            MappedByteBuffer inMap = in.map(FileChannel.MapMode.READ_ONLY, 0, size);
            MappedByteBuffer outMap = out.map(FileChannel.MapMode.READ_WRITE, 0, size);
            byte[] buffer = new byte[inMap.limit()];
            inMap.get(buffer);
            outMap.put(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
