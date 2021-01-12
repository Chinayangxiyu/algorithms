package com.yu.algorithms.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-09 16:35
 */
public class leetcode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return  Collections.EMPTY_LIST;
        }

        Arrays.sort(nums);

        if(nums[0] > 0 || nums[nums.length-1] < 0){
            return Collections.EMPTY_LIST;
        }

        List<List<Integer>> result = new ArrayList();
        int a;
        int sum;
        int i = 0;
        for(; i < nums.length && nums[i] <=0; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            a = nums.length - 1;
            two:for(int j = i + 1; j < a ; j++){
                if(j > (i+1) && nums[j] == nums[j-1]){
                    continue;
                }

                sum = nums[j] + nums[i];

                if(sum > 0){
                    break two;
                }

                if(sum * -1 > nums[a]){
                    break two;
                }
                while(a > j && nums[a] >= sum){
                    a--;
                }
                if(a+1 < nums.length && nums[a+1] == sum){
                    result.add(Arrays.asList(nums[i], nums[j], nums[a+1]));
                }

            }
        }
        return result;
    }

}
