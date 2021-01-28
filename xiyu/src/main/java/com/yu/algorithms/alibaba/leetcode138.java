package com.yu.algorithms.alibaba;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-19 15:46
 */
public class leetcode138 {

    public Node copyRandomList(Node head) {
        Map<Node, Integer> indexMap = new HashMap<>();

        // 第三部封装结果
        Map<Integer, Node> resMap = new HashMap<>();
        Node resHead= new Node(0);
        Node resCur= resHead;
        Node cur = head;
        int index = 0;
        while (cur != null){
            indexMap.put(cur, index);

            Node n = new Node(cur.val);
            resCur.next = n;
            resCur = n;
            resMap.put(index, n);

            cur = cur.next;
            index++;

        }

        // 第二步获取random的索引
        Map<Integer, Integer> indexMapRandomIndex = new HashMap<>();
        cur = head;
        index = 0;
        while(cur != null){
            indexMapRandomIndex.put(index++, indexMap.get(cur.random));
            cur = cur.next;
        }

        cur = resHead.next;
        index = 0;
        while (cur != null){

            Node r = resMap.get(indexMapRandomIndex.get(index++));
            cur.random = r;
            cur = cur.next;

        }

        return resHead.next;

    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
