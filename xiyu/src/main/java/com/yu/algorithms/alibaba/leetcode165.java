package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-04 15:23
 */
public class leetcode165 {

    public int compareVersion(String version1, String version2) {

        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split(".");

       int n1 = array1.length,n2 = array2.length;

       for (int i = 0; i < Math.max(n1, n2); i++){

           int l1 = n1 > i ? Integer.valueOf(array1[i]) : 0;
           int l2 = n2 > i ? Integer.valueOf(array2[i]) : 0;

           if(l1 != l2){
               return l1 > l2 ? 1 : -1;
           }
       }


        return 0;
    }

    private int compare(String version1, int start1, int end1, String version2, int start2, int end2){

        while (end1 >= start1 || end2 >= start2){
            char c1 = '0';
            if(end1 >= start1){
                c1 = version1.charAt(end1--);
            }

            char c2 = '0';
            if(end2 >= start2){
                c2 = version2.charAt(end2--);
            }

            if(c1 > c2){
                return 1;
            }

            if(c1 < c2){
                return -1;
            }

        }

        return 0;
    }
}
