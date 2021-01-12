package com.yu.algorithms;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-07 19:36
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
