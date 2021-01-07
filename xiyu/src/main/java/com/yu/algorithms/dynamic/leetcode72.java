package com.yu.algorithms.dynamic;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-05 15:10
 */
public class leetcode72 {


    public static void main(String[] args){

        leetcode72 l = new leetcode72();

        System.out.println(l.minDistance("horse",
                "ros"));
    }


    /**
     * 1、删除 等价于插入；
     * 2、
     * 2、和机器人最小路径对比，删除 等于向右移动，替换等于向下移动；本质上的操作类型只有两个；
     * 每个位置也有两种操作可以选择，所以最终每个位置的操作数可以组成一个二维表格
     */
    public int minDistance(String word1, String word2) {

        if(word1.equals(word2)){
            return 0;
        }

        if(word1.length() == 0 || word2.length() ==0 ){
            return word1.length() == 0 ? word2.length() : word1.length();
        }

        // 创建二维数组
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i =0; i<= m; i++){
            dp[i][0] = i;
        }

        for(int i = 0; i <= n; i++){
            dp[0][i] = i;
        }


        for(int i = 1; i <= m; i ++){

            for(int j = 1; j <= n; j++){
                int left = dp[i][j-1] + 1;
                int down = dp[i-1][j] + 1;
                int leftDown = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    leftDown +=  1;
                }

                dp[i][j] = Math.min(Math.min(left, down), leftDown);

            }
        }



        return dp[m][n];

    }

}
