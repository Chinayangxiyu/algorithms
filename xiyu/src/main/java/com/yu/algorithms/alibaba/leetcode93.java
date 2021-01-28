package com.yu.algorithms.alibaba;

import com.yu.algorithms.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-26 15:01
 */
public class leetcode93 {


    private void find(TreeNode root){


        List<Integer> res = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);

            if(cur.right != null){
                stack.push(cur.right);
            }

            if(cur.left != null){
                stack.push(cur.left);
            }

        }


    }



    public static void main(String[] args){
        leetcode93 l = new leetcode93();
        l.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {

        build(s, 0, 2, 0);
        return res;
    }

    StringBuilder temp = new StringBuilder();
    List<String> res = new ArrayList<>();
    StringBuilder sign = new StringBuilder();
    private void build(String s, int start, int end, int p){

        if(s.charAt(start) == '0' || s.charAt(start) > '2' || (p == 3 && end > s.length())){
            temp.delete(0, s.length());
            return;
        }

        if(p == 3){
            for(int i = start; i < s.length(); i++){
                temp.append(s.charAt(i));
            }
            res.add(temp.toString());
            temp.delete(0, s.length());
            return;
        }


        for(int i = start; i <=end && i <= 3; i++){

            int j = start;
            for(; j <= i; j++){
                if(j - start ==0 && (s.charAt(j) == '0' || s.charAt(j) > '2')){
                    temp.delete(start, temp.length());
                    return;
                }

                if(j - start == 1){}
                temp.append(s.charAt(j));
            }

            temp.append('.');
            build(s, j, j+2, p+1);

        }

    }
}
