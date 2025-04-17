package com.personal.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {
    @Test
    public void test1() throws IOException {
        System.out.println(File.pathSeparator); //:;
        System.out.println(File.separator); //:\
        System.out.println("-----+"+new File("").getAbsolutePath()+"+-----");
        System.out.println("-----+"+new File("").getPath()+"+-----");

        System.out.println("-----+"+new File("").getCanonicalPath()+"+-----");
        int[] ints = new int[1024];
        System.out.println(ints.length);
    }

    @Test
    public void test2(){
        //public File(String pathname)
        File file1 = new File("/Users/Morgan/IdeaProjects/JavaLearn/JavaSE/test1.text");
        File file2 = new File(File.separator+"Users"+File.separator+"Morgan"+File.separator
        +"IdeaProjects"+File.separator+"JavaLearn"+File.separator+"JavaSE"+File.separator+"test2.text");
        System.out.println(file1);
        System.out.println(file2);
        //public File(String parent,String child)
        File file3 = new File("/Users/Morgan/IdeaProjects/JavaLearn/JavaSE","dir");
        //public File(File parent,String child)
        File file4 = new File(file3,"test4.text");
        System.out.println(file3);
        System.out.println(file4);

    }

}
