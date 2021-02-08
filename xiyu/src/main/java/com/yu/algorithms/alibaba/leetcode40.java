package com.yu.algorithms.alibaba;

import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-07 10:37
 */
public class leetcode40 {


    public static void main(String[] args) {
        leetcode40 l = new leetcode40();
        int[] nums = new int[]{10,1,2,7,6,1,5};
//        int[] nums = new int[]{1,2,2,2,5};
        l.combinationSum2(nums, 8);

    }

    /**
     * 1、数组排序；
     * 2、回溯算法，
     * 3、需要考虑连续的重复值，保证连续的值都是以连续区间最后一个数结尾
     *  举例([1,2,2,2,2,4,5], 8) 我们判定重复区间时候应该每次都有包含最后一个元素，保证不重复计算
     *      【1，2，2，2，2】
     *      【1， ，2，2，2】
     *      【1， ， ，2，2】
     *      【1， ， ， ，2】
     *      【1， ， ， ， 】
     *
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if(Objects.isNull(candidates) || candidates.length == 0) {
            return Collections.EMPTY_LIST;
        }

        this.target = target;
        Arrays.sort(candidates);
        find(candidates, 0, 0);
        return res;

    }

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int target;
    private void find(int[] candidates, int p, int sum){

        // 结果判定
        if(sum == target){
            // p为边界，或 candidates[p] ！= candidates[p-1]才能获取结果；比如([1,2,2,2,5],5)
            // 计算的时候不同个数的2只能取一次，那我们以每次必取最后一个2为标准，剔除重复组合
            if(p == candidates.length || (candidates[p] != candidates[p-1])){
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        // 边界处理
        if(p == candidates.length || sum > target){
            return;
        }


        cur.add(candidates[p]);
        find(candidates, p+1, sum+candidates[p]);
        cur.remove(cur.size()-1);

        // 出现重复值区间时，当前值如果和cur的最后一个元素相等，不能剔除后继续递归。
        // 举例([1,2,2,2,2,4,5], 8) 我们判定重复区间时候应该每次都有包含最后一个元素，保证不重复计算
        // 【1，2，2，2，2】
        // 【1， ，2，2，2】
        // 【1， ， ，2，2】
        // 【1， ， ， ，2】
        // 【1， ， ， ， 】
        if(!cur.isEmpty() && cur.get(cur.size()-1) == candidates[p]){
            return;
        }

        find(candidates, p+1, sum);

    }
}
