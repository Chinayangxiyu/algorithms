package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-05 10:17
 */
public class leetcode43 {


    public static void main(String[] args) {
        leetcode43 l = new leetcode43();
        System.out.println(l.multiply1("123", "456"));
    }





    public String multiply1(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int[] temp = new int[num1.length() + num2.length()];
        for(int i = num1.length()-1; i >=0; i-- ){
            int a = num1.charAt(i) - '0';
            for(int j = num2.length()-1; j >=0; j--){
                int b = num2.charAt(j) - '0';
                temp[i+j+1] += a * b ;
            }
        }

        for(int k = temp.length-1; k > 0; k--){

            temp[k-1] = temp[k-1] + temp[k]/10;
            temp[k] %= 10;
        }

        StringBuilder res = new StringBuilder();
        boolean f = false;
        for (int k = 0; k < temp.length; k++){
            if(f || temp[k] != 0){
                f = true;
                res.append(temp[k]);
            }
        }


        return res.toString();
    }


    static int[] container = new int[58];
    static {
        container[48] = 0;
        container[49] = 1;
        container[50] = 2;
        container[51] = 3;
        container[52] = 4;
        container[53] = 5;
        container[54] = 6;
        container[55] = 7;
        container[56] = 8;
        container[57] = 9;
    }

    public String multiply(String num1, String num2) {

        if(num1.length() == 1 && num1.charAt(0) == '0'){
            return num1;
        }
         if(num2.length() == 1 && num2.charAt(0) == '0'){
            return num2;
        }

        StringBuilder builder = new StringBuilder();
        StringBuilder curStr = new StringBuilder();




        int j = num2.length()-1;
        int prefix = 0;

        int res;
        while (j >=0){
            int k = prefix;
            while (k > 0){
                curStr.append('0');
                k--;
            }

            int base = container[num2.charAt(j)];
            int pre = 0;
            int i = num1.length()-1;
            for(; i >=0; i--){
                res = base * container[num1.charAt(i)] + pre;
                if(res >= 10){
                    pre = res/10;
                    curStr.append(res % 10);
                }else{
                    pre = 0;
                    curStr.append(res);
                }
            }

            if(pre != 0){
                curStr.append(pre);
            }
            builder = merge(builder, curStr);
            prefix ++;
            j--;
            curStr.delete(0, curStr.length());

        }

        return builder.reverse().toString();
    }

    private StringBuilder merge(StringBuilder s1, StringBuilder s2){
        int i = 0;
        int j = 0;
        int pre = 0;
        StringBuilder temp = new StringBuilder();
        while (i < s1.length() || j < s2.length()){
            int a = 0;
            if(i < s1.length()){
                a = container[s1.charAt(i)];
                i++;
            }

            int b = 0;
            if(j < s2.length()){
                b =  container[s2.charAt(j)];
                j++;
            }

            int res = a + b + pre;
            if(res >= 10){
                pre = 1;
                temp.append(res % 10);
            }else{
                pre = 0;
                temp.append(res);
            }
        }

        if(pre != 0){
            temp.append(0);
        }



        return temp;
    }

}
