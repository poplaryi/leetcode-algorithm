package com.yangyi.code.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(10100);
        while (true) {
            System.out.println("等待连接");
            Socket accept = socket.accept();
            System.out.println("客户端连接了");

            byte[] bytes = new byte[1024];
            System.out.println("准备read");
            int read = accept.getInputStream().read(bytes);
            System.out.println("read完毕");
            if (read != -1) {
                System.out.println("收到客户端的数据：" + new String(bytes, 0, read));
            }
        }
    }


}
