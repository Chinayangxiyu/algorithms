package com.yu.algorithms.alibaba;

import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-29 12:37
 */
public class leetcode347 {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> valueCount = new HashMap<>();
        PriorityQueue<CountValue> queue  = new PriorityQueue(k, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {



                return ((CountValue) o1).getCount().compareTo(((CountValue) o2).getCount());
            }
        });


        for(int i = 0; i < nums.length; i++){

            Integer count = valueCount.get(nums[i]);
            if(count == null){
                valueCount.put(nums[i], 1);
            }else{
                valueCount.put(nums[i], ++count);
            }

        }

        for(Map.Entry<Integer, Integer> entry : valueCount.entrySet()){
            if(queue.size() < k ){
                CountValue cur = new CountValue(entry.getKey(), entry.getValue());
                queue.offer(cur);
                continue;
            }

            if(entry.getValue() > queue.peek().getValue()){
                queue.poll();
                CountValue cur = new CountValue(entry.getKey(), entry.getValue());
                queue.offer(cur);
                continue;
            }
        }

        int[] res = new int[k];
        int i = 0;
        while(!queue.isEmpty()){
            res[i++] = queue.poll().getValue();
        }
        return res;
    }

}


class CountValue{

    private Integer value;
    private Integer count;

    public CountValue(Integer value, Integer count) {
        this.value = value;
        this.count = count;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

