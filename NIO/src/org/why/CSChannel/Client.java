package org.why.CSChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author ：why
 * @date ：Created in 2020/5/5 19:35
 * @description：
 * @version:
 */
public class Client {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9999));
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("我是客户端,我来访问你了~".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);

        ByteBuffer byteBufferIn = ByteBuffer.allocate(1024);
        socketChannel.read(byteBufferIn);
        byteBufferIn.flip();
        System.out.println(new String(byteBufferIn.array(), 0, byteBufferIn.limit()));
        socketChannel.close();
    }
}
