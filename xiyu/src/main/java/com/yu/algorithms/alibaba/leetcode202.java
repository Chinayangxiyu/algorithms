package com.yu.algorithms.alibaba;

import java.util.HashSet;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-04 15:57
 */
public class leetcode202 {


    public static void main(String[] args) {

        System.out.println(0 % 10);
        System.out.println(0 >> 1);
    }
    public boolean isHappy(int n) {
        HashSet<Integer> sigton = new HashSet<>();

        while (n != 1){
            if(sigton.contains(n)){
                return false;
            }
            sigton.add(n);
            n = getNext(n);

        }

        return true;
    }


    private int getNext(int n){

        int sum = 0;
        int s = 10;
        while (n > 0){
            sum += (n % s) * (n % s);
            n /= s;
            s *= 10;
        }

        return sum;
    }
}
