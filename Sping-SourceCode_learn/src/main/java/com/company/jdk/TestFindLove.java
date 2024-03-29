package com.company.jdk;

import com.company.custom.ThisAgency;

public class TestFindLove {
    public static void main(String[] args) {
//        new Hank().findLove();
        try {
//            Person hank =(Person) new ProxyInstance().getInstance(new Hank());
            Person hank =(Person) new ThisAgency().getInstance(new Hank());
            System.out.println("The instance of proxy is : " + hank.getClass());
            hank .findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
