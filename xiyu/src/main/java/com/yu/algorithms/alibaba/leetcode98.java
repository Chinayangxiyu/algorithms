package com.yu.algorithms.alibaba;

import com.yu.algorithms.TreeNode;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-29 14:00
 */
public class leetcode98 {

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }

        return dfs(root.left,  Long.MAX_VALUE, Long.MIN_VALUE) ;

    }

    private boolean dfs(TreeNode root, long max, long min){

        if(root == null){
            return true;
        }

        boolean lb = dfs(root.left, root.val, min);
        boolean rb = dfs(root.right,  max, root.val);

        return root.val < max && root.val > min && lb && rb;
    }



}
