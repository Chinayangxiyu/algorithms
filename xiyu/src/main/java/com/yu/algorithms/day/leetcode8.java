package com.yu.algorithms.day;

import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-10 21:49
 */
public class leetcode8 {


    public static void main(String[] args){

        leetcode8 l = new leetcode8();
      String s1 = "00000-42a1234";
      System.out.println(l.myAtoi(s1));
    }


    static Map<Character, NType> container = new HashMap<Character, NType>();
    static {
        container.put('+',  NType.symble);
        container.put('-', NType.symble);

        container.put(' ', NType.space);

        container.put('0', NType.number);
        container.put('1', NType.number);
        container.put('2', NType.number);
        container.put('3', NType.number);
        container.put('4', NType.number);
        container.put('5', NType.number);
        container.put('6', NType.number);
        container.put('7', NType.number);
        container.put('8', NType.number);
        container.put('9', NType.number);
    }



    /**
     * 1、
     */
    public int myAtoi(String s) {

        return 0;
    }
}

enum NType {

    symble,
    space,
    number,
    other;


    private NType tail;


}
