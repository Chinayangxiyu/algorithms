package com.yu.algorithms.day;

import com.yu.algorithms.ListNode;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-11 17:24
 */
public class leetcode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode cur = head;

        for(int i = 0; i < n; i++){
            cur = cur.next;
        }

        if(cur == null){
            return head.next;
        }

        ListNode targetpre = head;
        ListNode target = head.next;
        cur = cur.next;
        while(cur != null){
            targetpre = target;
            target = target.next;
            cur = cur.next;
        }

        targetpre.next = target.next;
        return head;

    }
}
