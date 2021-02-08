package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-02 15:18
 */
public class leetcode34 {


    public static void main(String[] args){
        leetcode34 l = new leetcode34();
        int[] nums = new int[]{5,7,7,8,8,10};
        l.searchRange(nums, 6);
    }

    public int[] searchRange1(int[] nums, int target) {

        int count = 0;
        int end = nums.length-1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                count++;
            }
            if (nums[i] > target){
                end = i-1;
                break;
            }
        }

        if(count == 0){
            return new int[]{-1, -1};
        }
        return new int[]{end-count+1, end};
    }



    public int[] searchRange(int[] nums, int target) {

        int start = findLeft(nums, target, 0, nums.length-1);
        int end = findRight(nums, target, 0, nums.length-1);


        return new int[]{start, end};
    }



    /**
     * 二分查找左边界
     */
    private int findLeft(int[] nums, int target, int left, int right){

        if(left >= right){
            return -1;
        }
        int mid = (left + right)/2;

        if(nums[mid] >= target){

            if (nums[mid] == target && (mid == 0 || (nums[mid-1] < target))){
                return mid;
            }

            return findLeft(nums, target, left, mid);
        }else{
            return findLeft(nums, target, mid, right);
        }
    }

    private int findRight(int[] nums, int target, int left, int right){

        if(left >= right){
            return -1;
        }
        int mid = (left + right)/2;

        if(nums[mid] <= target){

            if (nums[mid] == target && (mid == nums.length-1 || (nums[mid+1] > target))){
                return mid;
            }

            return findRight(nums, target, mid, right);

        }else{
            return findRight(nums, target, left, mid);
        }
    }
}
