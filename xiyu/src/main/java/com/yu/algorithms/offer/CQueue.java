package com.yu.algorithms.offer;

import java.util.Stack;

/**
 *
 */
public class CQueue {

    Stack<Integer> add = new Stack();
    Stack<Integer> delete = new Stack();

    public CQueue() {

    }

    public void appendTail(int value) {

        add.push(value);


    }

    public int deleteHead() {
        while (!add.isEmpty()){
            delete.push(add.pop());
        }


        if(delete.isEmpty()){
            return -1;
        }

        int delValue = delete.pop();

        while(!delete.isEmpty()){
            add.push(delete.pop());
        }

        return delValue;
    }
}
