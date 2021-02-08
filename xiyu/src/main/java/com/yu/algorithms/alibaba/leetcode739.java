package com.yu.algorithms.alibaba;

import java.util.Stack;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-01 16:37
 */
public class leetcode739 {

    public int[] dailyTemperatures(int[] T) {

        Stack<Integer> stack = new Stack<>();

        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++){
            int temp = T[i];

            while (!stack.isEmpty() && T[stack.peek()] < temp){

                int day = stack.pop();
                res[day] = i-day;
            }

            stack.push(i);
        }

        return res;
    }
}
