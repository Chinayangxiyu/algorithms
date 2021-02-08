package com.yu.algorithms.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-30 21:34
 */
public class leetcode39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.targetSum = target;
        res = new ArrayList<>();

        calc(candidates, 0, 0, new ArrayList<>());
        return res;
    }

    int targetSum;
    List<List<Integer>> res;
    private void calc(int[] candidates, int p, int sum, List<Integer> list){

        if(p >= candidates.length || sum > targetSum){
            return;
        }



        // 当前元素参与计算
        int curSum = sum + candidates[p];
        list.add(candidates[p]);
        if(curSum == targetSum){
            res.add(new ArrayList<>(list));
        }

//        calc(candidates, p+1, curSum, list);


        calc(candidates, p, curSum, list);
        list.remove(list.size()-1);
        calc(candidates, p+1, sum, list);

    }
}
