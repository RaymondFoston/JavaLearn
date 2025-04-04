package com.personal.io;

import org.junit.Test;

import java.io.*;

/**
 * 文本文件的读取和写入
 * FileReader, FileWriter
 */
public class Demo3 {
    //默认是覆盖模式
    @Test
    public void write1() throws IOException {
        FileWriter fileWriter = new FileWriter(new File("").getPath()+"src/main/resources/test.text");
        /**
         * write和append功能一样，前者不能直接写null，后者可以
         */
        fileWriter.write("abc");
        fileWriter.append("123");
//        fileWriter.write(null);//不能直接些null
        fileWriter.append(null);//可以直接写null
        fileWriter.flush();
        System.out.println(fileWriter.getEncoding());
        fileWriter.close();
    }

    /**
     * 打开追加模式
     * @throws IOException
     */
    @Test
    public void write2() throws IOException {
        //文件绝对路径=拼接路径（项目绝对路径+文件所在目录）
        FileWriter fileWriter = new FileWriter(new File("").getAbsoluteFile()+"/src/main/resources/test.text",true);
        fileWriter.write("Hello World!\n");
        fileWriter.write("我覆盖前面的内容\n");
        fileWriter.append("我追加前面的内容\n");
        fileWriter.flush();
        System.out.println(fileWriter.getEncoding());
        fileWriter.close();
    }
    @Test
    public void read1() throws IOException {
        //文件相对路径
        FileReader fileReader = new FileReader("src/main/resources/test.text");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        while ((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }
        fileReader.close();
        bufferedReader.close();
    }
    @Test
    public void read2() throws IOException {
        FileReader fileReader = new FileReader(new File("") + "src/main/resources/test.text");
        int c;
        while ((c=fileReader.read())!=-1) {
            System.out.println(c);
        }

    }

}
