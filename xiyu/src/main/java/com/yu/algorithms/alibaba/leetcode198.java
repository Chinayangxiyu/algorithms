package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-21 14:14
 */
public class leetcode198 {

    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return nums[1] > nums[0] ? nums[1] : nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = Math.max(nums[1], (nums[0] + nums[2]));
        for(int i = 3; i < nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], Math.max(dp[i-1], dp[i-3] + nums[i]));
        }

        return dp[nums.length-1];
    }
}
