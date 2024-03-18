package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

//@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        int[] nums = {1,10,0,6,5};
//        for (int num:nums){
//            System.out.println(num);
//        }
        int index;
        index = pivotIndex(nums);
        System.out.println(index);

        index = pivotIndex1(nums);

        System.out.println(index);
    }

    public int pivotIndex(int[] nums) {
        int length = nums.length;
        for(int i=0;i<length;i++){
            int front=0,back=0;
            for (int j=0;j<i;j++){
                front += nums[j];
            }
            for (int k=length-1;k>i;k--){
                back += nums[k];
            }
            if (back != front) {
                continue;
            } else {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex1(int[] nums) {
        int length = nums.length;
        int tatal = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i=0;i<length;i++){
            if (2*leftSum + nums[i]==tatal){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

}
