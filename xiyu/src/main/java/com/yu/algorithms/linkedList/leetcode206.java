package com.yu.algorithms.linkedList;

import com.yu.algorithms.ListNode;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-07 22:18
 */
public class leetcode206 {

    public ListNode reverseList(ListNode head) {

        ListNode result = new ListNode(0);
        ListNode cur;
        while (head != null){
            cur = head;
            cur.next = result.next;
            result.next = cur;

            head = head.next;
        }


        return result.next;
    }

}
