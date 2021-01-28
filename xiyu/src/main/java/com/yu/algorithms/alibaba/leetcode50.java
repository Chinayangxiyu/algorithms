package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-18 10:24
 */
public class leetcode50 {


    public static void main(String[] args){
        leetcode50 l =new leetcode50();
        System.out.println(l.myPow(1, -2147483648));
    }

    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }

        if(n == 1){
            return x;
        }

        double res = quickMul(x, Math.abs(n));

        return n > 0 ? res : 1/res;

    }

    public double quickMul(double x, int n){
        if(n == 0){
            return 1;
        }

        double res = quickMul(x, n/2);
        res *= res;
        return (n % 2) == 0 ? res : (res * x);

    }
}
