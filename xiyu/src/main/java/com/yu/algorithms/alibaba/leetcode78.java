package com.yu.algorithms.alibaba;

import java.util.*;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-28 13:59
 */
public class leetcode78 {
    public List<List<Integer>> subsets(int[] nums) {

        find(nums, 0, 0);
        return res;
    }


    LinkedList<Integer> temp = new LinkedList<>();
    List<List<Integer>> res = new ArrayList();
    private void find(int[] nums, int p, int index){
        if(p == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }

        temp.addLast(nums[p]);
        find(nums, p+1, index+1);

        temp.remove(index);
        find(nums, p+1, index);

    }

}
