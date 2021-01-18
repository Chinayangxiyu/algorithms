package com.yu.algorithms.alibaba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class leetcode46 {



    public static void main(String[] args){
        leetcode46 l =new leetcode46();
//        fill();

    }



    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums.length == 1){
            List<Integer> l = new ArrayList<Integer>();
            l.add(nums[0]);
            result.add(l);
            return result;
        }

        List<Integer> container = new ArrayList<Integer>();
        for(int a : nums){
            container.add(a);
        }

        fill(result, 0, nums, container);
        return result;
    }
    public void fill(List<List<Integer>> result, int p, int[] nums, List<Integer> container){
        if(p == nums.length){
            result.add(new ArrayList(container));
            return;
        }

        for(int i = p; i < nums.length; i++){
            Collections.swap(container, p, i);
            fill(result, i+1, nums, container);
            Collections.swap(container, i, p);

        }

    }
}

//
//    public Node flatten(Node head) {
//        Node temp = new Node();
//
//        temp.next = head;
//        Node cur = head;
//
//        build(cur, temp.next);
//        return temp.next;
//    }
//
//    private Node build(Node cur, Node last){
//
//        while(cur != null){
//            if(cur.child != null){
//                last.next = cur.child;
//                last = last.next;
//                last = build(cur.child, last);
//            }
//
//            if(cur.next != null){
//                last.next = cur.next;
//                last = last.next ;
//                cur = cur.next;
//            }
//        }
//
//        return last;
//
//    }