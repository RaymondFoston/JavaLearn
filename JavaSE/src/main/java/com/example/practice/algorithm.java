package com.example.practice;

import org.junit.Test;

import java.util.Arrays;

public class algorithm {
    public int[] twoSum(int[] nums, int target){
        int len = nums.length;
        int[] indices = new int[0];
        for(int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                if(nums[i]+nums[j]==target&&i!=j){
                    indices = new int[]{i, j};
                }
            }
        }

        return indices;
    }

    @Test
    public void test1(){
        int[] array = twoSum(new int[]{2, 4, 6, 9},10);
        for(int i:array){
            System.out.println(i);
        }
        System.out.println(Arrays.toString(array));
    }
}
