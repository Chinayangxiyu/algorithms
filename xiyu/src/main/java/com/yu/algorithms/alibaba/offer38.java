package com.yu.algorithms.alibaba;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-25 14:44
 */
public class offer38 {

    public String[] permutation(String s) {

        find(s.toCharArray(), 0);

        String[] result = new String[res.size()];

        int i = 0;
        for(String c : res){
            result[i++] = c;
        }

        return result;


    }

    Set<String> res = new HashSet();
    private void find(char[] array, int index){

        if(index == array.length){
            res.add(new String(Arrays.copyOf(array, array.length)));
            return;
        }

        char temp;
        int i = index;
        while(i < array.length){
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;

            find(array, index + 1);

            array[i] = array[index];
            array[index] = temp;
            i++;
        }
    }
}
