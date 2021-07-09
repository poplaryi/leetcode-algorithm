package com.yangyi.code.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class NIOClient2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world".getBytes());
        outputStream.close();
    }
}
