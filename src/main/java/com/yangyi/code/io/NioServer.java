package com.yangyi.code.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NioServer {

    static List<SocketChannel> channelList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();

        socketChannel.socket().bind(new InetSocketAddress(10100));

        socketChannel.configureBlocking(false);

        System.out.println("服务启动成功");

        while (true){
            SocketChannel accept = socketChannel.accept();
            if(accept!=null){
                System.out.println("连接成功");
                accept.configureBlocking(false);
                channelList.add(accept);
            }
            Iterator<SocketChannel> iterator = channelList.iterator();

            while (iterator.hasNext()){
                SocketChannel next = iterator.next();
                ByteBuffer byteBuffer = ByteBuffer.allocate(128);
                int read = next.read(byteBuffer);
                if(read>0){
                    System.out.println("接收到消息："+new String(byteBuffer.array()));
                }else if(read == -1){
                    iterator.remove();
                    System.out.println("客户端断开连接了");
                }
            }
        }
    }
}
