package com.personal.variable;


import org.junit.Test;

public class App {
    @Test
    public void test1(){
        long value3 = 2147483647;
        int a = 2147483647;
        System.out.println(value3==a);
    }

    @Test
    public void test2(){
        int i = 1;
        String s = "abc";
        boolean b = true;
        System.out.println(i + s + b);
    }

    @Test
    public void test3(){
        String s = "20";
        Integer i = new Integer(s);
        System.out.println(i.intValue()+22);
    }

    @Test
    public void test4(){
        String str1 = "4";
        String str2 = 3.5f + "";
        System.out.println(str2);
        System.out .println(3+4+"Hello!");
        System.out.println("Hello!"+3+4);
        System.out.println('a'+1+"Hello!");
        System.out.println("Hello"+'a'+1);
    }
     @Test
    public void test5(){
         System.out.println("*    *");				//输出：
         System.out.println("*\t*");					//输出：
         System.out.println("*" + "\t" + "*");		//输出：
         System.out.println('*' + "\t" + "*");		//输出：
         System.out.println('*' + '\t' + "*");		//输出：
         System.out.println('*' + "\t" + '*');		//输出：
         System.out.println("*" + '\t' + '*');		//输出：
         System.out.println('*' + '\t' + '*');		//输出：
     }
}
