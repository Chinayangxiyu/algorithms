package com.yu.algorithms.alibaba;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-08 18:24
 */
public class leetcode6 {


    public static void main(String[] args){


        leetcode6 l = new leetcode6();
        System.out.println(l.convert1("PAYPALISHIRING",
                3));
//
    }





    public String convert2(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }

        // 每半个Z字，组成的字符的数量
        int a = 2 * numRows-2;

        List<StringBuilder> list = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }


        for(int i = 0; i < s.length(); i++){

            // 第一行
            if(i % a < numRows){
                list.get(i % a).append(s.charAt(i));
            }else{
                list.get(2*numRows - i % a -2).append(s.charAt(i));
            }
        }

        for(int i = 1; i < numRows; i++){
            list.get(0).append(list.get(i));
        }


        return list.get(0).toString();
    }


    // 1、两列完整的字符直接空格为 numRows-2
    // 2、创建一个二维数组，包含numRows个一维数组，每个一维数组的长度=x;
    //  numRows + numRows -2
    public String convert1(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }
        StringBuilder result = new StringBuilder();

        // 每半个Z字，组成的字符的数量
        int a = 2 * numRows-2;
        // 一共能组成多少半个Z字符，有可能除不尽，除不尽的余数
        int total = s.length() % a == 0 ?  s.length()/a : s.length()/a + 1;
        // 每半个Z的宽度
        int wide = numRows-1;
        // 每一行数组的长度 = total * （每半个Z的宽度）
        int size = total * wide;

        int index;

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < size ; j++){

                // 如果当前位置处于直线部分
                // 计算index索引，(j/wide) 表示当前处于第多少个半Z;
                // i + (j/wide) * a计算出当前字符的索引位置
                if(j % wide == 0 && (index = i + (j/wide) * a) < s.length()){
                    result.append(s.charAt(index));

                    // 处于斜线部分,i + (j%wide) 等于 wide说明在斜线上；
                    //
                }else if( i + (j%wide) == wide && (index = 2*numRows -2-i + (j/wide) * a) < s.length()){
                    result.append(s.charAt(index));

                }
            }
        }

        return result.toString();


    }


    public String convert(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }
        int count = s.length()/ (2*numRows-2);// 多少个循环半Z, 剩余的余数最后处理
        int size = count * (1 + numRows - 2 ); // 一维数组的长度,
        size = size == 0 ? 2*numRows-2 : size;
        size += ((s.length() % (2*numRows-2)) > 0 ? (2*numRows-2) : 0);
        char[][] array = new char[numRows][size];

        // 遍历二维数组，填充
        int sign = 0;
        for(int j = 0; j < size && sign < s.length(); j++){
            for(int i = 0; i < numRows && sign < s.length(); i++){
                // 如果属于Z字的，前部
                if(j % (numRows-1) ==0){
                    array[i][j] = s.charAt(sign++);
                }else if((j % (numRows-1) + i) == numRows-1){
                    array[i][j] = s.charAt(sign++);
                }
            }
        }



        StringBuilder result = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < size; j++){
                if(array[i][j] != 0){
                    result.append(array[i][j]);
                }
            }
        }

        return result.toString();

    }
}
