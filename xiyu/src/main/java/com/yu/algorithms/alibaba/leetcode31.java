package com.yu.algorithms.alibaba;

import java.util.Arrays;

/**
 *实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 */
public class leetcode31 {


    public static void main(String[] args){



        System.out.println((int)'1');
        System.out.println((int)'9');
    }


    /**
     * 123
     * 132
     * @param nums
     */
    public void nextPermutation(int[] nums) {


        int target = -1;
        int max = -1;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] < nums[i+1]){
                target = i;
                break;
            }
        }

        if(target == -1){
            Arrays.sort(nums, 0, nums.length);
            return;
        }


        for(int i = nums.length-1; i > 0; i--){
            if(nums[i] > nums[target]){
                max = i;
                break;
            }
        }

        if(max == -1){
            Arrays.sort(nums, 0, nums.length);
            return;
        }


        int temp = nums[target];
        nums[target] = nums[max];
        nums[max] = temp;


        Arrays.sort(nums, target+1, nums.length);
    }



}
