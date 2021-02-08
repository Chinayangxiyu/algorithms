package com.yu.algorithms.alibaba;

/**
 *
 * Description
 *
 * @author xiyu
 * @date 2021-02-01 14:51
 */
public class lttecode309 {


    /**
     * 第i天手里的股票状态一共有三种
     * 手里有股票f[i][0]；手里没股票、处于冷冻期f[i][1]；手里没股票、不处于冷冻期f[i][2]。
     * 1、手里有股票的利润计算：
     *  i-1天肯定有股票，如果是i-1天买入的，那么i-1天手里是没股票的：f[i-1][2] +
     *
     */

    //[1,2,3,0,2]
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }

        int[] profit = new int[prices.length];
        profit[0] = 0;
        profit[1] = Math.max(prices[1] - prices[0], 0);
        if(prices.length == 2){
            return Math.max(0, profit[1]);
        }


        profit[2] = Math.max(0, Math.max(prices[2] - prices[1], prices[2] - prices[0]));
        if(prices.length == 3){
            return Math.max(Math.max(0, profit[1]), profit[2]);
        }
        for(int i = 3; i < prices.length; i++){

            // i-3卖出， profit = profit[i-3] + (prices[i] - prices[i-1])

            int a = profit[i-3] + Math.max(prices[i] - prices[i-1], 0);

            // i-3不卖出
            int c = profit[i-3] +  Math.max(prices[i] - prices[i-3], 0);

            // i-2卖出，profit = profit[i-2];
            int b = profit[i-2];


            // i-2卖出， profit = profit[i-2]
            profit[i] = Math.max(Math.max(a, b), c);
            // 1 - 3
            // 1
            // 2-3
        }

        return profit[profit.length-1];
    }
}
