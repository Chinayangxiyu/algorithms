package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-11 18:20
 */
public class leetcode11 {




    public static void main(String[] args){
        leetcode11 l =new leetcode11();
        l.maxArea(new int[]{2,3,4,5,18,17,6});

    }

    /**
     * a + x > cur - b
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int rmin;
        int lmin = 0;
        int maxArea = 0;
        int jinit = height.length-1;
        int tempArea;
        for(int i = 0; i < height.length -1; i++){

            if(height[i] <= lmin){
                continue;
            }

            lmin = height[i];
            rmin = 0;
            for(int j = jinit; j > i; j--){

                if(height[j] <= rmin){
                    continue;
                }


                tempArea = (j-i) * (height[i] > height[j] ? height[j]:height[i]);
                maxArea = tempArea > maxArea ? tempArea : maxArea;

                if(height[j] > height[i]){
                    break;
                }
                rmin = height[j];
            }
        }

        return maxArea;
    }
}
