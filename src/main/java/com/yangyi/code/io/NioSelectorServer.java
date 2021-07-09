package com.yangyi.code.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioSelectorServer {
    public static void main(String[] args) throws IOException {

        //第一步：创建服务端选择器

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //  第二步：绑定服务端端口

        serverSocketChannel.socket().bind(new InetSocketAddress(10100));

        //  第三步：设置为非阻塞的

        serverSocketChannel.configureBlocking(false);

        //  第一步：创建客户端选择器

        Selector selector = Selector.open();

        //  第二步：将通道注册到选择器上

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务启动成功");

        while (true) {
            selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = server.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("客户端连接成功");
                } else if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                    int read = socketChannel.read(byteBuffer);
                    if (read > 0) {
                        System.out.println("接收消息：" + new String(byteBuffer.array()));
                    } else if (read == -1) {
                        System.out.println("客户端断开连接");
                        socketChannel.close();
                    }
                }
                iterator.remove();
            }
        }
    }
}
