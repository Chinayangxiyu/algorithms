package com.yu.algorithms.dynamic;

/**
 *
 */
public class leetcode63 {


    public static void main(String[] args){

        leetcode63 l = new leetcode63();

        int[][] array = new int[][]{{0,0}, {1,1}, {0,0}};

        System.out.println(l.uniquePathsWithObstacles1(array));
    }

    /**
     * 1、转换公式
     * f(n, n) = f(n , n-1) + f(n-1, n);
     *
     * 2、初始化：
     * 初始化第一行和第一列的值
     */
    /**
     * 二维数组方案
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length; // 高度
        int n = obstacleGrid[0].length; // 宽度

        int[][] dp = new int[m][n];
        // 初始化
        for(int i = 0; i < n ; i++){
            if(obstacleGrid[0][i] == 0){
                dp[0][i] = 1;
            }else{
                break;
            }
        }


        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            }else{
                break;
            }
        }

        for(int i = 1; i < m; i++){

            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[m-1][n-1];
    }

    /**
     * 空间优化方法
     */
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        // 边界问题处理，起点终点障碍，直接返回0
        if(obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length -1 ] ==1){
            return 0;
        }

        // 临时数组，缓存上一次计算得到的结果
        int[] temp = new int[obstacleGrid[0].length];
        // 本次计算的数组
        int[] dp = new int[obstacleGrid[0].length];
        // 最终的结果
        int last = 0;
        // 初始化值
        temp[0] = 1;
        dp[0] = 1;


        // 循环遍历
        for(int i = 0; i < obstacleGrid.length; i++){
            // 如果第一列出现障碍物(值为1)，第一列剩下的元素路径数是0
            if(obstacleGrid[i][0] == 1){
                dp[0] = 0;
                temp[0] = 0;
            }

            // 遍历每行元素
            for(int j = 1; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }else{
                    dp[j] = dp[j-1] + temp[j];
                }
            }
            // 记录当前最后一个元素的值
            last = dp[obstacleGrid[0].length-1];
            int[] a  =temp;
            temp = dp;
            dp = a;
        }

        return last;
    }
}
