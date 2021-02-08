package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-31 14:59
 */
public class leetcode85 {

    public int maximalRectangle(char[][] matrix) {

        int maxArea = 0;
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    maxArea = Math.max(maxArea, find(matrix, i, j));
                }
            }
        }

        return maxArea;

    }


    private int find(char[][] matrix, int i, int j){

        int rightMax = matrix[0].length;
        int areaMax = 0;
        for(int a = i; a < matrix.length; a++){
            if(matrix[a][j] == '0'){
                return areaMax;
            }

            for(int b = j; b < rightMax; b++){
                if(matrix[a][b] == '1'){
                    areaMax = Math.max(areaMax, (a-i + 1) * (b-j+1));
                }else{
                    rightMax = b;
                    break;
                }
            }
        }

        return areaMax;

    }
}
