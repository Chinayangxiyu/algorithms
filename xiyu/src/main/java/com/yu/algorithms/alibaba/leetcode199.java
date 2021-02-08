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
 * @date 2021-01-28 10:28
 */
public class leetcode199 {

    // 宽度优先，获取每一层最右边的元素
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return Collections.EMPTY_LIST;
        }

        List<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.addFirst(root);
        while(!temp.isEmpty()){

            TreeNode last = temp.peekLast();
            res.add(last.val);
            while(!temp.isEmpty()){
                TreeNode cur = temp.pollFirst();

                if(cur.left != null){
                    temp.addLast(cur.left);
                }

                if(cur.right != null){
                    temp.addLast(cur.right);
                }

                if(cur == last){
                    break;
                }


            }
        }

        return res;

    }
}
