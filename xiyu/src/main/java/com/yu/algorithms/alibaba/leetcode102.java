package com.yu.algorithms.alibaba;


import com.yu.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-18 11:02
 */
public class leetcode102 {

    public List<List<Integer>> levelOrder(TreeNode root){

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList();




        queue.addFirst(root);
        int ccount = 0;
        int precount = 1;

        while (queue.peekLast() != null){
            TreeNode cur = queue.pollLast();
            curList.add(cur.val);
            precount--;


            if(cur.left != null){
                queue.addFirst(cur.left);
                ccount++;
            }
            if(cur.right != null){
                queue.addFirst(cur.right);
                ccount++;

            }

            if(precount == 0){
                precount = ccount;
                ccount = 0;
                res.add(curList);
                curList = new ArrayList<>();
            }


        }

        return res;
    }
}
