package com.yu.algorithms.alibaba;

import com.yu.algorithms.ListNode;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-22 21:54
 */
public class leetcode92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode reversePre = null;
        ListNode reverseHead = null;
        ListNode tail = null;
        int p = 0;
        while(head != null){
            p++;
            if(p < m){
                if(p == m-1){
                    reversePre = head;
                }
                head = head.next;
                continue;
            }

            if(p == m){
                tail = head;
            }

            if(p == n){
                tail.next = head.next;
                head.next = reverseHead;
                reversePre.next = head;
                return reversePre;

            }

            ListNode curnext = head.next;
            head.next = reverseHead;
            reverseHead = head;
            head = curnext;
        }

        return reversePre;

    }
}
