package com.yu.algorithms.alibaba;

import java.util.PriorityQueue;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-11 15:40
 */
public class leetcode215 {


    public static void main(String[] args){
        leetcode215 l =new leetcode215();
       l.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);

    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> temp = new PriorityQueue(k);

        for(int i = 0; i < k ; i++){
            temp.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++){
            if(temp.peek() < nums[i]){
                temp.poll();
                temp.add(nums[i]);
            }
        }

        return temp.peek();
    }
}
