package com.yangyi.code.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer2 {

    public static void main(String[] args) throws IOException {
        //创建选择器
        Selector selector = Selector.open();

        //将通道注册到选择器上
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //服务端端口绑定
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress("localhost", 8888));

        while (true) {
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                if (key.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    System.out.println(readDataFromChannel(channel));
                    channel.close();
                }
                keyIterator.remove();
            }
        }
    }

    private static String readDataFromChannel(SocketChannel socketChannel) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            byteBuffer.clear();
            int n = socketChannel.read(byteBuffer);
            if (n == -1) {
                break;
            }
            byteBuffer.flip();
            int limit = byteBuffer.limit();
            char[] chars = new char[limit];
            for (int i = 0; i < limit; i++) {
                chars[i] = (char) byteBuffer.get(i);
            }
            stringBuilder.append(chars);
            byteBuffer.clear();
        }
        return stringBuilder.toString();
    }
}
