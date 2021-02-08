package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-31 14:21
 */
public class leetcode240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int maxj = matrix[0].length;

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] > target){
                return false;
            }
            for(int j = 0; j < maxj; j++){
                if(matrix[i][j] > target){
                    maxj = j;
                    break;
                }

                if(matrix[i][j] == target){
                    return true;
                }
            }

        }

        return false;

    }
}
