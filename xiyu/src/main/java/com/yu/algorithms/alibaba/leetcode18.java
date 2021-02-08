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
        int[] nums = new int[]{-2,-1,-1,1,1,2,2};
        l.fourSum(nums, 2);
    }






//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        this.target = target;
//        find(nums, 0, 0, 0);
//        return new ArrayList<>(res);
//
//    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4){
            return Collections.EMPTY_LIST;
        }

        Arrays.sort(nums);
        int max = 0;
        for(int i = nums.length-1; i > nums.length-5; i--){
            max += nums[i];
        }

        if(max < target){
            return Collections.EMPTY_LIST;
        }

        int min = 0;
        for(int i = 0; i < 4; i++){
            min += nums[i];
        }
        if(min > target){
            return Collections.EMPTY_LIST;
        }




        this.target = target;
        find(nums, 0, 0, 0);
        return new ArrayList<>(res);

    }








    int target = 0;
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    Set<String> useSet = new HashSet<>();
    StringBuilder  str = new StringBuilder();
    private void find(int[] nums, int p, int count, int sum){


        if(count == 4){
            if(sum == target){
                String s = str.toString();
                if(useSet.contains(s)){
                    return;
                }

                res.add(new ArrayList(temp));
                useSet.add(s);
            }
            return;
        }

        if(p >= nums.length){
            return;
        }

        // 当前值参与计算
        int start = str.length();
        str.append(nums[p]);
        temp.add(nums[p]);
        find(nums, p+1, count+1, sum + nums[p]);
        temp.remove(temp.size()-1);
        str.delete(start, str.length());

        find(nums, p+1, count, sum);

    }
}
