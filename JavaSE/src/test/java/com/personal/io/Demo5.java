package com.personal.io;

import org.junit.Test;

import java.io.*;

/**
 * 复制文件
 */
public class Demo5 {
    //不使用缓冲
    @Test
    public void test1() throws IOException {
        FileInputStream in = new FileInputStream(new File("").getAbsolutePath()+"/src/main/resources/20mb.img");
        FileOutputStream out = new FileOutputStream("src/main/resources/test1.img");
        int len = 0;
        long begin = System.currentTimeMillis();
        while ((len=in.read())!=-1){
            out.write(len);
        }
        System.out.println("复制耗时："+ (System.currentTimeMillis()-begin)); //97989
        out.close();
        in.close();
    }
    //输入输出都不实用缓冲流
    @Test
    public void test2() throws IOException {
        FileInputStream in = new FileInputStream(new File("").getAbsolutePath()+"/src/main/resources/20mb.img");
        FileOutputStream out = new FileOutputStream("src/main/resources/test2.img");
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len=in.read(bs))!=-1){
            out.write(bs,0,len);
        }
        System.out.println("复制耗时："+ (System.currentTimeMillis()-begin));//297
        out.close();
        in.close();
    }
    //只有输入使用缓冲流
    @Test
    public void test3() throws IOException {
        FileInputStream in = new FileInputStream(new File("").getAbsolutePath()+"/src/main/resources/20mb.img");
        FileOutputStream out = new FileOutputStream("src/main/resources/test3.img");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while ((len = bufferedInputStream.read(bs))!=-1){
            out.write(bs,0,len);
        }
        System.out.println("复制耗时："+ (System.currentTimeMillis()-begin));//174
        bufferedInputStream.close();
        out.close();
        in.close();

    }
    //输入输出都使用缓冲流
    @Test
    public void test4() throws IOException {
        FileInputStream reader = new FileInputStream("src/main/resources/20mb.img");
        BufferedInputStream bufferReader = new BufferedInputStream(reader);
        FileOutputStream writer = new FileOutputStream("src/main/resources/test4.img");
        BufferedOutputStream bufferedWriter = new BufferedOutputStream(writer);
        int len = 0;
        byte[] bs = new byte[1024];
        long begin = System.currentTimeMillis();
        while((bufferReader.read(bs))!=-1){
            bufferedWriter.write(bs,0,len);
        }System.out.println("复制耗时："+ (System.currentTimeMillis()-begin));//51
        bufferedWriter.close();
        bufferReader.close();
        writer.close();
        reader.close();
    }

}
