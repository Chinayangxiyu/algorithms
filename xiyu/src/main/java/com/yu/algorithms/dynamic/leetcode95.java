package com.yu.algorithms.dynamic;

import com.yu.algorithms.TreeNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class leetcode95 {


    public static void main(String[] args){

        System.out.println((int)'a');
        System.out.println((int)'z');
        leetcode95 l = new leetcode95();

        l.validWordAbbreviation("leetcode", "l1e5");

    }


    public boolean validWordAbbreviation(String word, String abbr) {
        if(abbr.length() > word.length()){
            return false;
        }

        int cur = 0;
        StringBuilder countStr = new StringBuilder();
        for(int i = 0; i < abbr.length(); i++) {

            if(word.charAt(cur) == abbr.charAt(i) && countStr.length() ==0) {
                cur++;
                continue;
            }

            if(abbr.charAt(i) > 122 ||  abbr.charAt(i) < 97){
                // 数字首位为零
                if(countStr.length()==0 &&  abbr.charAt(i)=='0'){
                    return false;
                }
                countStr.append( abbr.charAt(i));

                // 不是数字
            }else {
                if(countStr.length() ==0){
                    return false;
                }
                Integer count = Integer.valueOf(countStr.toString());
                cur += count;
                if(cur > word.length()-1){
                    return false;
                }
                i--;
                countStr.delete(0, countStr.length());

            }

        }

        if(countStr.length() > 0){
            Integer count = Integer.valueOf(countStr.toString());
            cur += count;
        }


        return cur == word.length();
    }
}
