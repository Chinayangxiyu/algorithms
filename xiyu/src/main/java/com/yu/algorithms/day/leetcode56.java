package com.yu.algorithms.day;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-13 13:55
 */
public class leetcode56 {



    public static void main(String[] args){
        leetcode56 l =new leetcode56();


        int[][] nums = new int[][]{{1,3},{0,1}, {-3,5},{7,9}};
        l.quicksort(nums, 0, 3);
        int i = 9;

    }

    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1){
            return intervals;
        }

        quicksort(intervals, 0, intervals.length-1);

        int count = 0;
        int[] cur = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= cur[1] ){

                cur[1] = intervals[i][1] > cur[1] ?  intervals[i][1]:cur[1];
            }else{
                intervals[++count] = intervals[i];
                cur = intervals[i];
            }
        }

        int[][] result = new int[count + 1][];
        for(; count >= 0; count-- ){
            result[count] = intervals[count];
        }

        return result;
    }


    private static int[] cur;
    private void quicksort(int[][] nums, int left, int right){

        if(left >= right){
            return;
        }

        int i = left;
        int j = right;
        cur = nums[j];
        while(left < right){
            left = left(nums, left, right);
            right = right(nums, left, right);
        }

        nums[j] = nums[left];
        nums[left] = cur;
        quicksort(nums, i, left-1);
        quicksort(nums, right+1, j);

    }

    private int left(int[][] nums, int left, int right){

        for(int i = left ;i < right; i++){
            if(nums[i][0] > cur[0]){

                return i;
            }
        }

        return right;
    }

    private int right(int[][] nums, int left, int right){
        for(int j = right; j > left; j--){
            if(nums[j][0] < cur[0]){

                int[] temp = nums[left];
                nums[left] = nums[j];
                nums[j]=  temp;
                return j;

            }
        }
        return left;
    }
}
