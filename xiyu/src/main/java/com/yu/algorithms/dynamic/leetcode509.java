package com.yu.algorithms.dynamic;

/**
 *斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给你 n ，请计算 F(n) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fibonacci-number
 */
public class leetcode509 {


    public static void main(String[] args){

        leetcode509 l = new leetcode509();
        System.out.println(l.fib(6));
    }


    /**
     * 1、不能递归，递归溢出
     */
    public int fib(int n) {
        if(n <= 1){
            return n;
        }


        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
