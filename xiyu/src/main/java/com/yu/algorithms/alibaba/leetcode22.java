package com.yu.algorithms.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-14 16:33
 */
public class leetcode22 {


    public static void main(String[] args){

        int i = 4 ^ 4;

        System.out.println(i);




    }

    public List<String> generateParenthesis(int n) {


        char[] temp = new char[2*n];
        temp[0] = '(';

        List<String> res = new ArrayList<String>();
        fill(res, temp, 1, n-1, n);

        return res;
    }

    private void fill(List<String> res, char[] temp, int p, int left, int right){
        if(p == temp.length){
            char[] end = new char[temp.length];
            System.arraycopy(temp, 0, end, 0, temp.length);
            res.add(new String(end));
        }


        if(left > 0){
            temp[p] = '(';
            fill(res, temp, p + 1, left-1, right);
        }

        if(right > left){
            temp[p] = ')';
            fill(res, temp, p + 1, left, right-1);

        }

    }
}
