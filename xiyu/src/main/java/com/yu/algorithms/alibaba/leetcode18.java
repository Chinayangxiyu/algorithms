package com.yu.algorithms.alibaba;

import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-05 14:21
 */
public class leetcode18 {

    public static void main(String[] args) {
        leetcode18 l = new leetcode18();
//        int[] nums = new int[]{1,0,-1,0,-2,2};
//        int[] nums = new int[]{1,0,-1,0,-2,2};
//        int[] nums = new int[]{2,1,0,-1};
//        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        int[] nums = new int[]{-3,-1,0,2,4,5};
        List<List<Integer>>  res = l.fourSum(nums, 0);
        System.out.println(res.size());
    }





    /**
     * 一、暴力破解
     * 嵌套四层for循环，每一层处理一个元素。
     *
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        int sum = 0;
        for(int i = 0; i < nums.length-3; i++){
            // 重复组合
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            sum += nums[i];

            for(int j = i+1; j<  nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                sum += nums[j];

                for(int a = j+1; a < nums.length-1; a++){
                    if(a > j+1 && nums[a] == nums[a-1]){
                        continue;
                    }
                    sum += nums[a];


                    for(int b = a+1; b < nums.length; b++){
                        if(b > a+1 && nums[b] == nums[b-1]){
                            continue;
                        }
                        sum += nums[b];
                        if(sum > target){
                            sum -= nums[b];
                            break;
                        }
                        if(sum == target){
                            res.add(Arrays.asList(nums[i], nums[j], nums[a], nums[b]));
                        }
                        sum -= nums[b];
                    }
                    sum -= nums[a];

                }
                sum -= nums[j];
            }

            sum -= nums[i];
        }

        return res;

    }

    /**
     *
     * 暴力优化
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
//        if(nums == null || nums.length < 4){
//            return Collections.EMPTY_LIST;
//        }

        Arrays.sort(nums);


//        int max = 0;
//        for(int i = nums.length-1; i > nums.length-5; i--){
//            max += nums[i];
//        }
//
//        if(max < target){
//            return Collections.EMPTY_LIST;
//        }
//
//        int min = 0;
//        for(int i = 0; i < 4; i++){
//            min += nums[i];
//        }
//
//        if(min > target){
//            return Collections.EMPTY_LIST;
//        }


        List<List<Integer>> res = new ArrayList<>();

        int sum = 0;
        int size3 = nums.length-3;
        int size2 = nums.length-2;
        int size1 = nums.length-1;
        int prej;
        int prea;
        int preb;
        for(int i = 0; i < size3; i++){
            // 重复组合
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            sum += nums[i];

            prej = i+1;
            for(int j = prej; j< size2; j++){
                if(j > prej && nums[j] == nums[j-1]){
                    continue;
                }
                sum += nums[j];

                prea = j+1;
                for(int a = prea; a < size1; a++){
                    if(a > prea && nums[a] == nums[a-1]){
                        continue;
                    }
                    sum += nums[a];

                    preb = a+1;
                    for(int b = preb; b < nums.length; b++){
                        if(b > preb && nums[b] == nums[b-1]){
                            continue;
                        }
                        sum += nums[b];
                        if(sum == target){
                            res.add(Arrays.asList(nums[i], nums[j], nums[a], nums[b]));
                        }
                        sum -= nums[b];
                    }
                    sum -= nums[a];

                }
                sum -= nums[j];
            }

            sum -= nums[i];
        }

        return res;

    }
}
