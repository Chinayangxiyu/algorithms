package com.yu.algorithms.alibaba;

import com.yu.algorithms.ListNode;

import java.util.Stack;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-01 16:00
 */
public class leetcode234 {


    public boolean isPalindrome(ListNode head) {

        Stack<ListNode> temp = new Stack<>();

        ListNode cur = head;
        while (cur != null){
            temp.push(cur);
            cur = cur.next;
        }


        while (head != null){
            if(head.val != temp.pop().val){
                return false;
            }
        }

        return true;

    }
}
