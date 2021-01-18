package com.yu.algorithms.alibaba;

import com.yu.algorithms.ListNode;
import javafx.collections.transformation.SortedList;

import java.util.Map;
import java.util.TreeMap;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-17 13:40
 */
public class leetcode148 {


    /**
     * 解法二、归并排序
     * 1、使用快慢指针找到链表的中点，将链表分为两部分；
     * 2、对分割后的链表进行递归二分排序，最后合并两个子链表
     */
    public ListNode sortList(ListNode head) {


        return sort(head, null);
    }


    public ListNode sort(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }


        ListNode mid = head;
        ListNode two = head;
        while(two != tail && two.next != tail){
            mid = mid.next;
            two = two.next.next;
        }

        ListNode left = sort(head, mid);
        ListNode right = sort(mid, two);

        return merge(left, right);
    }

    // 合并两个有序链表
    private ListNode merge(ListNode left, ListNode right){
        ListNode result = new ListNode(0);


        ListNode cur = result;
        while(left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }else{
                cur.next = right;
                right = right.next;
            }
        }

        cur.next = left== null ? right : left;

        return result.next;

    }


        /**
         * 解法一
         * @param head
         * @return
         */
    public ListNode sortList1(ListNode head) {

        TreeMap<Integer, ListNode> map = new TreeMap<>();


        ListNode cur = head;
        ListNode result = new ListNode(0);

        while(cur != null){
            ListNode curNext = cur.next;

            Map.Entry<Integer, ListNode> lower = map.floorEntry(cur.val);

            if(lower != null){
                ListNode lnext = lower.getValue().next;
                lower.getValue().next = cur;
                cur.next = lnext;
            }else{

                ListNode lnext = result.next;
                result.next = cur;
                cur.next = lnext;



            }
            map.put(cur.val, cur);

            cur = curNext;

        }

        return result.next;

    }

    }
