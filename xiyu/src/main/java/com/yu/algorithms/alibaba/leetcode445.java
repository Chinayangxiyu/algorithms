package com.yu.algorithms.alibaba;

import com.yu.algorithms.ListNode;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-30 20:44
 */
public class leetcode445 {

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
    }

    /**
     * 1、翻转两个链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = revert(l1);
        l2 = revert(l2);

        ListNode res = new ListNode(0);
        ListNode node = res;
        int temp = 0;
        int cur = 0;
        while(l1 != null || l2 != null){
            if(l1 != null){
                cur += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                cur += l2.val;
                l2 = l2.next;
            }
            cur += temp;

            if(cur > 10){
                cur %= 10;
                temp = 1;
            }else{
                temp =0;
            }

            node.next = new ListNode(cur);
            node = node.next;
            cur = 0;
        }

        if(temp == 1){
            node.next = new ListNode(1);
        }

        res = res.next;

        return revert(res);



    }

    private ListNode revert(ListNode listNode){

        ListNode res = new ListNode(0);
        ListNode cur = null;
        while(listNode != null){
            ListNode n = listNode.next;

            listNode.next = cur;
            res.next = listNode;
            cur = listNode;

            listNode = n;
        }

        return res.next;

    }
}
