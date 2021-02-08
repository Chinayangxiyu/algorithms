package com.yu.algorithms.alibaba;

import com.yu.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-28 11:21
 */
public class leetcode103 {

    public static void main(String[] args){
        System.out.println(true ^ true);
        System.out.println(true ^ false);

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return Collections.EMPTY_LIST;
        }


        LinkedList<TreeNode> temp = new LinkedList();
        List<List<Integer>> res= new ArrayList<>();
        temp.addLast(root);
        boolean b = true;

        while(!temp.isEmpty()){

            List<Integer> list = new ArrayList();
            if(b){
                TreeNode last = temp.peekLast();
                while(!temp.isEmpty()){
                    TreeNode cur = temp.pollFirst();
                    if(cur.left != null){
                        temp.addLast(cur.left);
                    }

                    if(cur.right != null) {
                        temp.addLast(cur.right);
                    }

                    list.add(cur.val);
                    if(cur == last){
                        b = false;
                        break;
                    }
                }
            }else{
                TreeNode last = temp.peekFirst();
                while(!temp.isEmpty()){
                    TreeNode cur = temp.pollLast();
                    if(cur.right != null) {
                        temp.addFirst(cur.right);
                    }
                    if(cur.left != null){
                        temp.addFirst(cur.left);
                    }
                    list.add(cur.val);
                    if(cur == last){
                        b = true;
                        break;
                    }
                }

            }
            res.add(list);
        }

        return res;
    }
}
