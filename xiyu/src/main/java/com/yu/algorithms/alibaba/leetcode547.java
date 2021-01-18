package com.yu.algorithms.alibaba;

/**
 * 每日打卡
 *
 * @author xiyu
 * @date 2021-01-07 14:21
 */
public class leetcode547 {


    public static void main(String[] args){


//        leetcode547 l = new leetcode547();
//
//        int[][] array = new int[][]{{1, 0,0}, {0,1, 0}, {0,0, 1}};
//
//        System.out.println(l.findCircleNum(array));
    }

    /**
     * 解法一、递归遍历
     * （1）遍历第一列，如果存在值1，表明i,j属于一个省份; 并且将temp[i],temp[j]标记为1，说明已经处理过了；
     * （2）找到一个值为1后，遍历1所在的行；
     * （3）递归遍历，直到遍历结束。
     *
     */
    public int findCircleNum(int[][] isConnected) {

        int[] temp = new int[isConnected.length];
        int total = 0;
        for(int i = 0; i < temp.length; i++){
            if(temp[i] ==0){
                total += 1;
                findx(isConnected, i, temp);
            }
        }

        return total;
    }


    public void findx(int[][] isConnected, int x, int[] temp) {


        for(int i = 0; i < isConnected.length; i++){
            if(temp[i] == 0 && isConnected[x][i] == 1){
                temp[x]= 1;
                temp[i]=1;
                findy(isConnected, i, temp);
            }
        }


    }

    public void findy(int[][] isConnected, int y, int[] temp) {


        for(int i = 0; i < isConnected.length; i++){
            if(temp[i] == 0 && isConnected[i][y] == 1){
                temp[y]= 1;
                temp[i]=1;
                findx(isConnected, i, temp);
            }
        }
    }

}
