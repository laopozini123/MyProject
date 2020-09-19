package com.why.selectorDemo;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ：why
 * @date ：Created in 2020/5/5 19:50
 * @description：
 * @version:
 */
public class Server {
    public static void main(String[] args) throws Exception {
        // 创建三个端口号
        ServerSocketChannel serverSocketChannel7777 = ServerSocketChannel.open();
        serverSocketChannel7777.configureBlocking(false);
        serverSocketChannel7777.bind(new InetSocketAddress(7777));

        ServerSocketChannel serverSocketChannel8888 = ServerSocketChannel.open();
        serverSocketChannel8888.configureBlocking(false);
        serverSocketChannel8888.bind(new InetSocketAddress(8888));

        ServerSocketChannel serverSocketChannel9999 = ServerSocketChannel.open();
        serverSocketChannel9999.configureBlocking(false);
        serverSocketChannel9999.bind(new InetSocketAddress(9999));
        // 打开Selector
        Selector selector = Selector.open();

        // 将三个端口号注册到Selector中
        serverSocketChannel7777.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChannel8888.register(selector, SelectionKey.OP_ACCEPT);
        serverSocketChannel9999.register(selector, SelectionKey.OP_ACCEPT);
        // 模拟服务器不断的获取客户端的连接,用while  true循环
        while (true) {
            System.out.println("【服务器】通道开启,等待客户端连接............");
            selector.select(); // 在selectedKeys()中有客户端连接时,不阻塞,但是总数为0时会阻塞.
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            // 打印本次连接的数量
            System.out.println("集合大小：" + selectionKeys.size());

            //遍历已连接通道的集合
            Iterator<SelectionKey> it = selectionKeys.iterator();
            while (it.hasNext()) {
                //获取当前连接通道的SelectionKey
                SelectionKey key = it.next();
                //从SelectionKey中获取通道对象
                ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                //看一下此通道是监听哪个端口的
                System.out.println("监听端口：" + channel.getLocalAddress());
                SocketChannel socketChannel = channel.accept();
                ByteBuffer inBuf = ByteBuffer.allocate(100);
                socketChannel.read(inBuf);
                inBuf.flip();
                String msg = new String(inBuf.array(), 0, inBuf.limit());
                System.out.println("【服务器】接收到通道【" + channel.getLocalAddress() + "】的信息：" + msg);
                it.remove();
            }
            System.out.println("休息1秒......");
            Thread.sleep(1000);
            System.out.println();//打印一个空行
        }
    }
}
