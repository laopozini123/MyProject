package com.why.CSChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author ：why
 * @date ：Created in 2020/5/5 19:35
 * @description：
 * @version:
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(9999));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        socketChannel.read(byteBuffer);
        byteBuffer.flip();
        System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));

        ByteBuffer byteBufferOut = ByteBuffer.allocate(1024);
        byteBufferOut.put("我是服务器,我来服务你了~".getBytes());
        byteBufferOut.flip();
        socketChannel.write(byteBufferOut);
    }
}
