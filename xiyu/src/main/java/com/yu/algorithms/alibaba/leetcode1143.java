package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-08 15:27
 */
public class leetcode1143 {

    public static void main(String[] args) {
        leetcode1143 l = new leetcode1143();
        l.longestCommonSubsequence("bsbininm", "jmjkbkjkv");

    }

    // f(i,j) = Math.min(f(i-1,j), f(i,j-1)) + (text1[i] == text2[j] ? 1 : 0)
    /**
     *   a, b, c, d, e
     * a 1  1  1  1  1
     * c 1  1  2
     * e 1  1  2
     *
     */
    public int longestCommonSubsequence(String text1, String text2) {



        int[][] dp = new int[text2.length()][text1.length()];
        dp[0][0] = text2.charAt(0) == text1.charAt(0) ? 1 : 0;

        for(int i = 1; i < text1.length(); i++){
            if(text2.charAt(0) == text1.charAt(i)){
                dp[0][i] = 1;
            }else{
                dp[0][i] = dp[0][i-1];
            }

        }

        for(int i = 1; i < text2.length(); i++){
            if(text1.charAt(0) == text2.charAt(i)){
                dp[i][0] = 1;
            }else{
                dp[i][0] = dp[i-1][0];
            }
        }

        for(int i = 1; i < text2.length(); i++){

            for(int j = 1; j < text1.length(); j++){
                if(text1.charAt(j) == text2.charAt(i)){
                    dp[i][j] =  dp[i-1][j-1] +1;
                }else{
                    dp[i][j] =   Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text2.length()-1][text1.length()-1];

    }
}
