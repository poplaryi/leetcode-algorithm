package com.yangyi.code.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author kcyangyi@gmail.com
 */
public class FileIO {
    private static final String FILE_NAME = "/file.txt";

    /**
     * 写入文件有两种：
     * FileOutputStream
     * OutputStreamWriter
     *
     * 读取文件有三种：
     * FileInputStream
     * InputStreamReader
     * BufferedReader
     */

    /**
     * 字符写入文件-FileOutputStream
     *
     * @throws IOException
     */
    public static void fileOutStream() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
        outputStreamWriter.write("Hello");
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    /**
     * 字节写入文件-OutputStreamWriter
     *
     * @throws IOException
     */
    public static void outStream() throws IOException {
        byte[] bytes = {'a', 'b', 'c', 'd'};
        OutputStream outputStream = new FileOutputStream(FILE_NAME);
        outputStream.write(bytes);
        outputStream.close();
    }

    /**
     * 字符读取文件-FileInputStream
     *
     * @throws IOException
     */
    public static void fileInputStream() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
        int c;
        while ((c = inputStreamReader.read()) != -1) {
            System.out.print((char) c);
        }
        inputStreamReader.close();
        fileInputStream.close();
    }

    /**
     * 字节读取文件-InputStream
     *
     * @throws IOException
     */
    public static void fileInStream() throws IOException {
        InputStream inputStream = new FileInputStream(FILE_NAME);
        int size = inputStream.available();
        for (int i = 0; i < size; i++) {
            System.out.print((char) inputStream.read());
        }
        inputStream.close();
    }

    /**
     * 缓冲读取文件-BufferedReader
     *
     * @throws IOException
     */
    public static void bufferReader() throws IOException {
        InputStream inputStream = new FileInputStream(FILE_NAME);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.print(s);
        }
        bufferedReader.close();
        inputStream.close();
    }

    /**
     * 对象序列化写入文件-ObjectOutputStream
     */
    public static void objectOutputStream() throws IOException {
        String s = "Hello";
        byte[] bytes = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(s);
        objectOutputStream.writeObject(bytes);
        objectOutputStream.close();
        fileOutputStream.close();
    }

    /**
     * 对象序列化读取文件-ObjectInputStream
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void objectInputStream() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        System.out.println((String) objectInputStream.readObject());
        byte[] reads = (byte[]) objectInputStream.readObject();
        for (byte read : reads) {
            System.out.print((char) read);
        }
        objectInputStream.close();
        fileInputStream.close();
    }

    /**
     * 目录操作-创建目录
     */
    public static void createDir() {
        String dirName = "D://file/1/11";
        File file = new File(dirName);
        file.mkdir();
    }

    /**
     * 目录操作-读取目录
     */
    public static void openDir() {
        String dirName = "D://file";
        File file = new File(dirName);
        extracted(file);
    }

    /**
     * 目录操作-删除空目录
     */
    public static void removeDir() {
        String dirName = "D://file";
        File file = new File(dirName);
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                String name = f.getName();
                if (f.isDirectory()) {
                    System.out.println((f.delete() ? "成功删除目录" : "删除目录失败") + name);
                } else {
                    System.out.println((f.delete() ? "成功删除文件" : "删除文件失败") + name);
                }
            }
        }
    }


    private static void extracted(File file) {
        if (file.isDirectory()) {
            System.out.println("Dir:" + file.getName());
            String[] list = file.list();
            for (String s : list) {
                File f = new File(file.getPath() + "/" + s);
                extracted(f);
            }
        } else {
            System.out.println("File:" + file.getName());
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileIO.removeDir();
    }
}
