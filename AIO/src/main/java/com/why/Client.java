package com.why;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author ：why
 * @date ：Created in 2020/5/8 19:01
 * @description：
 * @version:
 */
public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousSocketChannel asynchronousSocketChannel =  AsynchronousSocketChannel.open();
       asynchronousSocketChannel.connect(new InetSocketAddress("localhost", 9999), null, new CompletionHandler<Void, Object>() {
           @Override
           public void completed(Void result, Object attachment) {
               System.out.println("连接成功");
               ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
               byteBuffer.put("我是客户端,我发来了数据!".getBytes());
               byteBuffer.flip();
               asynchronousSocketChannel.write(byteBuffer, null, new CompletionHandler<Integer, Object>() {
                   @Override
                   public void completed(Integer result, Object attachment) {
                       System.out.println("发送成功");
                   }

                   @Override
                   public void failed(Throwable exc, Object attachment) {
                       System.out.println("发送失败");
                   }
               });
           }

           @Override
           public void failed(Throwable exc, Object attachment) {
               System.out.println("连接失败~~~~~~~~~~~~~");
           }
       });

        Thread.sleep(10000);
    }
}
