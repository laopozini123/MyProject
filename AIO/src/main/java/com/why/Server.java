package com.why;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;

/**
 * @author ：why
 * @date ：Created in 2020/5/8 19:01
 * @description：
 * @version:
 */
public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress(9999));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Object attachment) {
                System.out.println("访问成功");
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                result.read(byteBuffer, 10, TimeUnit.SECONDS, null, new CompletionHandler<Integer, Object>() {
                    @Override
                    public void completed(Integer num, Object attachment) {
                        System.out.println("数据解析成功:" + num);
                        System.out.println(new String(byteBuffer.array(), 0, byteBuffer.limit()));
                    }

                    @Override
                    public void failed(Throwable exc, Object attachment) {

                    }
                });
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("访问失败");
            }
        });
        Thread.sleep(10000);
    }
}
