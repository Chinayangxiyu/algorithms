package com.yu.algorithms.alibaba;

import com.yu.algorithms.TreeNode;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-28 15:18
 */
public class leetcode543 {


    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left ==null && root.right == null)){
            return 0;
        }
        dfs(root, 0);
        return max;
    }

    private int max = 0;
    private int dfs(TreeNode root, int index){
        if(root == null){
            return 0;
        }

        int lh = dfs(root.left, index);

        int rh = dfs(root.right, index);

        max = max > (lh + rh ) ? max : (lh + rh);



        return lh > rh ? lh + 1 : rh + 1;

    }
}
