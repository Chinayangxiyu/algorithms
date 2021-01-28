package com.yu.algorithms.offer;

import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-26 15:53
 */
public class LRUCache {

    int count = 0;
    int capacity;


    HashMap<Integer, Integer> cache;
    LinkedList<Integer> keyCache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyCache = new LinkedList();
    }

    public int get(int key) {
        if(cache.get(key) == null){
            return -1;
        }

        Integer value = cache.get(key);

        Iterator<Integer> iterator = keyCache.iterator();

        while (iterator.hasNext()){
            int k = iterator.next();
            if(k == key){
                iterator.remove();
                keyCache.addLast(key);
                break;
            }
        }

        return value;

    }

    public void put(int key, int value) {


        if(cache.get(key) != null){
            cache.put(key, value);

            Iterator<Integer> iterator = keyCache.iterator();

            while (iterator.hasNext()){
                int k = iterator.next();
                if(k == key){
                    iterator.remove();
                    keyCache.addLast(key);
                    break;
                }
            }
            return;

        }




        if(count < capacity){
            cache.put(key, value);
            keyCache.addLast(key);
            count++;
            return;
        }


        Integer k = keyCache.removeFirst();
        cache.remove(k);

        cache.put(key, value);
        keyCache.addLast(key);

    }
}
