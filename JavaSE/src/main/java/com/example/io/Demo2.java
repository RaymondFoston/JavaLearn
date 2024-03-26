package com.example.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 写入读取二进制文件
 */
public class Demo2 {
    //写入二进制文件
    @Test
    public void writeByte() throws IOException {
        byte[] bytes = {12,54,23,74,20};
        FileOutputStream fileOutputStream = new FileOutputStream(new File("").getAbsolutePath()+ "test.byte");
        fileOutputStream.write(bytes);
        fileOutputStream.close();
    }

    //读取二进制文件
    @Test
    public void readByte() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("").getAbsolutePath()+ "test.byte");
        int c;
        while ((c = fileInputStream.read()) != -1){
            System.out.println(c);
        }

    }


}
