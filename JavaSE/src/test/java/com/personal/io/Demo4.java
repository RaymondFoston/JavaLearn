package com.personal.io;

import org.junit.Test;

import java.io.*;

/**
 * 文本文件的读取写入
 * InputStreamReader, OutputStreamWriter
 */
public class Demo4 {
    @Test
    public void writer () throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/test2.text");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.append("Hello,\n");
        outputStreamWriter.append("world!\n");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    @Test
    public void reader () throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/test2.text");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str;
        while ((str=bufferedReader.readLine())!= null) {
            System.out.println(str);
        }
    }
}
