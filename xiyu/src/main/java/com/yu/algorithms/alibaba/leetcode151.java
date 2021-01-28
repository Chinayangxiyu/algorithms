package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-24 20:32
 */
public class leetcode151 {

    public String reverseWords(String s) {
        s = s.trim();

        char[] temp = new char[s.length()];

        int i = s.length()-1;
        int previ = s.length()-2;
        int endIndex = s.length()-1;
        int p = 0;
        for(; previ >=0; i--, previ--){
            if(s.charAt(previ) == ' ' && s.charAt(i) != ' '){
                for(int j = i; j <= endIndex; j++){
                    temp[p++] = s.charAt(j);
                }
                temp[p++] = ' ';
                continue;
            }
        }

        return new String(temp, 0, p);
    }
}
