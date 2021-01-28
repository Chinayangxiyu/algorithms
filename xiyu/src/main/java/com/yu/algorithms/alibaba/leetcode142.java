package com.yu.algorithms.alibaba;

import com.yu.algorithms.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-21 14:18
 */
public class leetcode142 {


    /**
     * 1、哈希
     */
    public ListNode detectCycle1(ListNode head) {

        Set<ListNode> t = new HashSet<>();

        while (head != null){
            if(t.contains(head)){
                return head;
            }

            t.add(head);
            head = head.next;
        }

        return null;

    }

    /**
     * 快慢指针
     */
    public ListNode detectCycle2(ListNode head) {

        ListNode t = head;

        ListNode one  = head;
        ListNode two = head;
        while (two != null && two.next != null){
            one = one.next;
            two = two.next.next;

            if(one == two){
                while (t != one){
                    t = t.next;
                    one = one.next;
                }

                return one;
            }
        }




        return null;

    }
}
