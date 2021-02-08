package com.yu.algorithms.alibaba;

import java.lang.reflect.Array;
import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-08 14:09
 */
public class leetcode49 {

    //[["bdddddddddd","bbbbbbbbbbc"]]
    //[["bbbbbbbbbbc"],["bdddddddddd"]]
    // 7  000111
    // 8  001000
    public static void main(String[] args) {
        System.out.println((int)'z');
        System.out.println('a' ^ 'b');

        leetcode49 l = new leetcode49();
        String[] array = new String[]{"bdddddddddd","bbbbbbbbbbc"};
        l.groupAnagrams(array);
    }


    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> res = new ArrayList<>();
        int[] f = new int[strs.length];
        int[] cur = new int[123];
        for(int i = 0; i < strs.length; i++){
            if(f[i] == 1){
                continue;
            }
            f[i] = 1;
            String s = strs[i];
            List<String> list = new ArrayList<>();
            list.add(s);

            for(int k = 0; k < s.length(); k++){
                cur[s.charAt(k)] += 1;
            }

            label:for(int j = i+1; j< strs.length; j++){
                // 数量对不上
                if(f[j] == 1 || strs[i].length() != strs[j].length()){
                    continue;
                }

                int[] t = cur.clone();
                for (int k = 0; k < strs[j].length(); k++){
                    if(t[strs[j].charAt(k)] ==0){
                        continue label;
                    }
                    t[strs[j].charAt(k)] -= 1;
                }



                list.add(strs[j]);
                f[j] =1;
            }

            for(int k = 97; k< 123; k++){
                cur[k] =0;
            }

            res.add(list);

        }

        return res;

    }
}
