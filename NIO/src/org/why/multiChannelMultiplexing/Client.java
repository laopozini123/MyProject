package org.why.multiChannelMultiplexing;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author ：why
 * @date ：Created in 2020/5/5 19:50
 * @description：
 * @version:
 */
public class Client {
    public static void main(String[] args) {
        // 创建3个线程访问服务器的不同端口
        new Thread(() -> {
            try (SocketChannel socketChannel = SocketChannel.open();) {
                socketChannel.connect(new InetSocketAddress(7777));
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                byteBuffer.put((socketChannel.getLocalAddress() + "我是7777客户端,我来访问你了").getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try (SocketChannel socketChannel = SocketChannel.open();) {
                socketChannel.connect(new InetSocketAddress(8888));
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                byteBuffer.put((socketChannel.getLocalAddress() + "我是8888客户端,我来访问你了").getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try (SocketChannel socketChannel = SocketChannel.open();) {
                socketChannel.connect(new InetSocketAddress(9999));
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                byteBuffer.put((socketChannel.getLocalAddress() + "我是9999客户端,我来访问你了").getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
