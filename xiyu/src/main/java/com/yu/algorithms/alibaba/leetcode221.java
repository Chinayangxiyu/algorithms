package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-29 10:47
 */
public class leetcode221 {


    /**
     * 动态规划
     */
    public int maximalSquareDP(char[][] matrix) {

        int s1 = matrix.length;
        int s2 = matrix[0].length;
        int[][] dp = new int[s1][s2];

        int maxSize = 0;
       for(int i = 0; i < s1; i++){
           if(matrix[i][0] == '1'){
               dp[i][0] = 1;
               maxSize = 1;
           }
       }

       for(int j = 0; j < s2; j++){
           if(matrix[0][j] == '1'){
               dp[0][j] = 1;
               maxSize =1;
           }
       }

       for(int i = 1; i < s1; i++){
           for(int j = 1; j < s2; j++){
               if(matrix[i][j] == '1'){
                   dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                   maxSize = Math.max(maxSize, dp[i][j]);
               }
           }
       }

       return maxSize * maxSize;
    }

    public int maximalSquare(char[][] matrix) {

        int maxSize = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    maxSize = Math.max(find(matrix, i, j), maxSize);
                }
            }
        }


        return maxSize * maxSize;
    }

    private int size;
    int a;
    int b;
    private int find(char[][] matrix, int i, int j){
         size = 1;
         a = i+size;
         b = j+size;
        while(a < matrix.length && b < matrix[0].length){

            for(int k = j; k <= b; k++){
                if(matrix[a][k] == '0'){
                    return size;
                }
            }

            for(int l = i; l <= a; l++){
                if(matrix[l][b] == '0'){
                    return size;
                }
            }

            size++;

        }
       return size;

    }
}
