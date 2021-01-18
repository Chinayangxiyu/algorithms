package com.yu.algorithms.alibaba;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-14 21:52
 */
public class leetcode322 {


    public static void main(String[] args){
        leetcode322 l =new leetcode322();
        l.coinChange(new int[]{1,2,5}, 11);
//        fill();

    }

    /**
     * f(n) =Math.min(f(n-))
     */
    public int coinChange(int[] coins, int amount) {


        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount);

        // 初始化
        for(int i = 1; i < amount+1; i++) {
            int pre;
            for (int j = coins.length-1; j >= 0; j--) {
                if (i == coins[j]) {
                    dp[i] = 1;
                    continue;
                }

                if (i > coins[j] && (pre = dp[i - coins[j]]) != 0
                        && (dp[i] == 0 || pre < dp[i] - 1)) {
                    dp[i] = pre + 1;
                }

            }

        }

        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
