package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-02-04 16:20
 */
public class leetcode468 {

    public String validIPAddress(String IP) {
        if(IP.contains(".")){
            if(findIP4(IP)){
                return "IPv4";
            }
            return "Neither";
        }

        if(IP.contains(":")){

            if(findIP6(IP)){
                return "IPv6";
            }
            return "Neither";
        }
//        Character.isDigit(
        return "Neither";

    }


    private boolean findIP4(String IP){
        if(IP == null || IP.length() > 15 || IP.length() < 7){
            return false;
        }
        String[] array = IP.split("\\.");
        for(int i = 0; i < array.length; i++){

            if(array[i].length() ==0 || array.length > 3){
                return false;
            }

            if(array[i].charAt(0) == '0' && array[i].length() != 1){
                return false;
            }

            for (int k = 0; k < array[i].length(); k++){
                if(!Character.isDigit( array[i].charAt(k))){
                    return false;
                }
            }

            if(Integer.valueOf(array[i]) > 255 || Integer.valueOf(array[i]) <=0){
                return false;
            }

        }
        return true;

    }

    private boolean findIP6(String IP){
        String[] nums = IP.split(":", -1);
        String hexdigits = "0123456789abcdefABCDEF";
        return true;

    }

}
