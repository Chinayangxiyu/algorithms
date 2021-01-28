package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-24 21:53
 */
public class leetcode394 {


    public String decodeString(String s) {
        return fill(s, 0, s.length()-1);


    }

    // 解码
    public String fill(String s, int startIndex, int endIndex){

        StringBuilder res = new StringBuilder();
        // 缓存每个'['之前的数字
        StringBuilder countStr = new StringBuilder();
        Integer count;

        // 查找到'['表示起始索引；查找到和首个'['匹配的']'表示endIndex
        for(int i = startIndex; i <= endIndex; i++){
            // 遇到了需要解码字符串的开头
            if(s.charAt(i) == '['){

                count = Integer.valueOf(countStr.toString());
                // 匹配当前'['对应的']'的位置
                int nexeEndIndex = getEndIndex(s, i, endIndex);
                // 递归解码子串
                String child = fill(s, i+1, nexeEndIndex-1);
                // 填充
                for(int j = 0; j < count; j++){
                    res.append(child);
                }

                // 重置
                i = nexeEndIndex;
                countStr.delete(0, countStr.length());

                continue;
            }
            // 数字count
            if(s.charAt(i) >= 48 && s.charAt(i) <= 57 ){
                countStr.append(s.charAt(i));
                continue;
            }

            res.append(s.charAt(i));
        }

        return res.toString();

    }

    // 遍历获取匹配的']'索引
    private int getEndIndex(String s, int startIndex, int tail){
        int count = 1;
        for(int i = startIndex+1; i <= tail; i++){
            if(s.charAt(i) == '['){
                count++;
                continue;
            }

            if(s.charAt(i) == ']'){
                count--;
                if(count == 0){
                    return i;
                }
            }

        }

        return 0;

    }
}
