package com.yu.algorithms.dynamic;

/**
 *
 */
public class leetcode96 {


    public static void main(String[] args){

        leetcode96 l = new leetcode96();

        l.numTrees(2);
    }

    /**
     * 分析：假设以x为根节点， 以x为根的总数f(x);
     * 此时x左边有x-1个数，x-1个数组成的二叉搜索树的种类用函数g(x-1)表示；
     * x右边有 n-x个数， n-x个数组成搜索树的种类用函数g(n-x)表示；
     * f(x) = g(x-1) * g(n-x); 【注意】函数g表示的是由多少个值组成的树的种类； 函数f表示以当前值为根节点的树的组成个数。
     * 我们需要计算的结果g(n) = f(1) + f(1) + f(2)+....f(n);
     *
     * 推导公式(卡特兰数)
     * g(n) = g(0)*g(n-1) + g(1)*g(n-2) + ... g(n-1) * g(0);
     *
     * 我们直到g(0) =1, g(1)=1 可以递归计算出g(2), g(3) .... g(n)
     *
     *
     *
     */
    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        // 计算 g(n)的值
        for(int i = 2; i <= n; i++){

            // g(2) = g(0) * g(1) + g(1)*g(0)
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }

        }

        return dp[n];

    }
}
