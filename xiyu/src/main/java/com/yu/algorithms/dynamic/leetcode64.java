package com.yu.algorithms.dynamic;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-05 14:34
 */
public class leetcode64 {


    public static void main(String[] args){

        leetcode64 l = new leetcode64();

        int[][] array = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};

        System.out.println(l.minPathSum(array));
    }

    /**
     * 同63题类似，因为遍历后的空间不需要再次使用，所以也可以进行空间优化
     */
    public int minPathSum(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];

        temp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            temp[i][0] = grid[i][0] +  temp[i-1][0];
        }


        for (int j = 1; j < grid[0].length; j++){
            temp[0][j] = grid[0][j] +  temp[0][j-1];;
        }


        for(int i = 1; i < grid.length; i++){

            for(int j = 1; j < grid[0].length; j++){
                temp[i][j] = Math.min(temp[i-1][j], temp[i][j-1]) + grid[i][j];
            }
        }

        return temp[grid.length-1][grid[0].length-1];
    }
}
