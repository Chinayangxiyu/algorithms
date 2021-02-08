package com.yu.algorithms.alibaba;

import com.yu.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-30 21:18
 */
public class leetcode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        res = new ArrayList<>();
        find(root, new ArrayList<>(), 0);
        return res;
    }

    int targetSum;
    List<List<Integer>> res;
    private void find(TreeNode root, List<Integer> list, int sum){
        if(root == null){
            if(sum == targetSum){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        sum += root.val;
        list.add(root.val);
        find(root.left, list, sum);
        list.remove(list.size()-1);
        find(root.right, list, sum);
    }
}
