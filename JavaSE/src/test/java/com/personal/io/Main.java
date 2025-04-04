package com.personal.io;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println(File.pathSeparator); //:;
        System.out.println(File.separator); //:\
        System.out.println("-----+"+new File("").getAbsolutePath()+"+-----");
        System.out.println("-----+"+new File("").getPath()+"+-----");

        System.out.println("-----+"+new File("").getCanonicalPath()+"+-----");
        int[] ints = new int[1024];
        System.out.println(ints.length);
    }
}
