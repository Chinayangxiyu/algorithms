package com.yu.algorithms.alibaba;

import java.util.LinkedList;
import java.util.Stack;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-07 15:33
 */
public class leetcode402 {


    // 13421342  4
    // 13132    1132
    // 99999991111111
    public static void main(String[] args) {

        leetcode402 l = new leetcode402();
        System.out.println(l.removeKdigits("112", 1));
    }


    /**
     * 1、从左往右，如果num[i] > num[i+1]则num[i]需要移除；
     * 2、移除后需要判断num[i-1] 和num[i]的大小，直到num[i-n] <= num[i]成立，则将num[i]添加到队列
     */
    public String removeKdigits(String num, int k) {
        if(num.length() == k){
            return "0";
        }

        LinkedList<Character> stack = new LinkedList<>();

        // 使用单调栈，
        for(int i = 0; i < num.length(); i++){
            char cur = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > cur){
                stack.pollLast();
                k--;
            }
            stack.offerLast(cur);
        }

        // 此时stack序列肯定是按照升序排列的，既stack[i] < stack[i+1]是肯定成立的；
        // 例：1122334444555669999；最大的值都在队列尾部，此时如果k还不为零，则直接移除队列尾部对应个数的值
       while (k > 0){
           stack.pollLast();
           k--;
       }

       // 结果返回
        StringBuilder res = new StringBuilder();
        boolean f = stack.peekFirst() == '0' ? false : true;
        while (!stack.isEmpty()){
            if (f){
                res.append(stack.pollFirst());
                continue;
            }

            if(stack.peekFirst() == '0'){
                f = true;
                stack.pollFirst();
            }
        }

        if(res.length() == 0){
            return "0";
        }

        return res.toString();


    }
}
