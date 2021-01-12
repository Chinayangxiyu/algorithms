package com.yu.algorithms.day;

import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-09 10:27
 */
public class leetcode535 {


    public static void main(String[] args){
        System.out.println(pre.length());
        leetcode535 l =new leetcode535();
        String s = l.encode("https://leetcode.com/problems/design-tinyurl");
        l.decode(s);
    }


    static final List<String> container = new ArrayList<String>();
    static final String pre = "http://tinyurl.com/";
    int count = 0;


    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        container.add(longUrl);
        return pre + (container.size()-1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        String cstr = shortUrl.substring(19);
        return container.get(Integer.valueOf(cstr));
    }
}
