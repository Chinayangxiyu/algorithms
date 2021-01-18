package com.yu.algorithms;

import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-15 13:47
 */
public class leetcode947 {


    public static void main(String[] args){
        leetcode947 l = new leetcode947();

        int[][] array = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(l.removeStones(array));

    }

    Map<Integer, List<int[]>> a = new HashMap<>();
    Map<Integer, List<int[]>> b = new HashMap<>();
    public int removeStones(int[][] stones) {


        for(int i = 0; i < stones.length; i++){
            int[] t = stones[i];
            if(a.get(t[0]) == null){
                List<int[]> list = new ArrayList<>();
                list.add(t);
                a.put(t[0], list);
            }else{
                a.get(t[0]).add(t);
            }

            if(b.get(t[1]) == null){
                List<int[]> list = new ArrayList<>();
                list.add(t);
                b.put(t[1],list);
            }else{
                b.get(t[1]).add(t);
            }
        }

        int max = 0;
        for(Integer i : a.keySet()){
            max = Math.max(find(i, true, 0), max);
        }


        return max;
    }


    private int find( int p, boolean f, int count){

        if(f){
            List<int[]> temp = a.get(p);
            count += temp.size();
            List<Integer> nextp = new ArrayList<>();
            for(int i = temp.size()-1; i >=0; i--){
                nextp.add(temp.get(i)[1]);
                temp.remove(i);
            }

            for(int i = 0; i < nextp.size(); i++){
                count = find(nextp.get(i), false, count);
            }
        }

        if(!f){
            List<int[]> temp  = b.get(p);
            List<Integer> nextp = new ArrayList<>();

            for(int i = temp.size()-1; i >=0; i--){
                nextp.add(temp.get(i)[0]);
                temp.remove(i);

            }
            for(int i = 0; i < nextp.size(); i++){
                count = find(nextp.get(i), true, count);
            }
        }


        return count;

    }


}
