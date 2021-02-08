package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-31 14:36
 */
public class leetcode695 {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null){
            return 0;
        }

        int maxSum = 0;
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    maxSum = Math.max(find(grid, i, j, 0), maxSum);
                }
            }
        }

        return maxSum;
    }


    private int find(int[][] grid, int i, int j, int sum){

        if(grid[i][j] == 0){
            return sum;

        }

        sum += 1;
        grid[i][j] = 0;

        // 网上找
        if(i > 0){
            sum = find(grid, i-1, j, sum);
        }

        if(i < grid.length-1){
            sum = find(grid, i+1, j, sum);
        }

        if(j > 0){
            sum = find(grid, i, j-1, sum);
        }

        if(j < grid[0].length-1){
            sum = find(grid, i, j+1, sum);
        }

        return sum;
    }
}
