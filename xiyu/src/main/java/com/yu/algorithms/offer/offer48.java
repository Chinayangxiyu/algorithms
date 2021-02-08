package com.yu.algorithms.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-08 15:05
 */
public class offer48 {


    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> curMap = new HashMap<>();
        int maxCount = 0;
        int count = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(curMap.containsKey(s.charAt(i))){
                maxCount = Math.max(maxCount, count);
                int end = curMap.get(s.charAt(i));

                for(int j = start; j <= end; j++){
                    curMap.remove(s.charAt(j));
                }

                count = count - (end-start+1);
                start = end+1;
            }

            count++;
            curMap.put(s.charAt(i), i);
        }

        return Math.max(maxCount, count);

    }
}
