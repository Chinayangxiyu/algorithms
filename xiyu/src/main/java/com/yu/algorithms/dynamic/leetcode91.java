package com.yu.algorithms.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-05 19:11
 */
public class leetcode91 {


    public static void main(String[] args){



        leetcode91 l = new leetcode91();

        // 1 1 2 5
        System.out.println(l.numDecodings("2611055971756562"));
    }


    /**
     * 模拟爬楼梯题目，当前位置为n，那么n的编码方式，有以下两种情况
     * （1）f[n]单独编码，那么f[n]位置的编码方式满足 f(n) = f(n-1);
     * （2）f(n)和f(n-1)组成一个小于26的数字混合编码；因为一次编码占了两位所以满足 f(n) = f(n-2)
     * 转换编公式：f(n) = f(n-1) + f(n-2)
     *
     * 边界条件的限制
     * （1）单独的0不能组成编码方式，0只能参与组成10，20两个数；
     * （2）如果当前字符不是0，则和前一个字符组合；
     * 如果组合的结果小于26则满足f(n) = f(n-1) + f(n-2)；否则f(n)=f(n-1)
     *
     * 初始化，字符的长度需要大于等于2
     * s[0] != '0'; 则f(0) = 1;
     * f(1)的初始化需要根据s[1]是否为0，以及和s[0]的组合结果来初始化。
     *
     */
    public int numDecodings(String s) {

        // 边界处理
        if(s.charAt(0) == '0'){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }

        int size = s.length();

        // 初始化
        int[] dp = new int[size];
        dp[0] = 1;

        // 初始化 dp[1]
        if(s.charAt(1) == '0'){
            // 编码不合格
            if(s.charAt(0) > '2'){
                return 0;
            }
            dp[1] = 1;

        }else{

                // 编码值小于等于26
            if(s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) < '7')){
                dp[1] = 2;
                // 编码值大于26
            }else{
                dp[1] = 1;
            }
        }
        for(int i = 2; i < size; i++){

            // 如果当前值为0
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) > '2' || s.charAt(i-1) == '0'){
                    return 0;
                }else{
                    dp[i] = dp[i-2];
                }
                // 如果能和前一个字符组成小于 26的数
            }else{
                if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) < '7')){
                    dp[i] = dp[i-1] + dp[i-2];
                }else{
                    dp[i] = dp[i-1];
                }

            }
        }



        return dp[size-1];
    }
}
