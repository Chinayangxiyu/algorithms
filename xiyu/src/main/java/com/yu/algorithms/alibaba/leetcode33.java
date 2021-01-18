package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-11 21:48
 */
public class leetcode33 {


    public static void main(String[] args){
        leetcode33 l =new leetcode33();
        System.out.println(l.search(new int[]{4,5,6,7,0,1,2}, 1));

    }

    /**
     * 2、mid = (l + r)/2;
     * （1）当nums[mid] > nums[l]的时候，mid位于前半段升序数组中，推断target位置；
     * nums[l] < target < nums[mid];则在前半段完全升序区间；
     * target > nums[mid] || target < nums[r]则在后半段区间
     * 其它情况则不满足，返回-1
     * （2）当nums[mid] < nums[r]时，mid位于后半段升序数组中， 推断target位置；
     * nums[mid] < target < nums[r],target位于后半段升序组数；
     *  nums[l] < target || target < nums[mid]，target位于前半段数组；
     * 其它情况则不满足，返回-1
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {


        int mid;
        int l = 0;
        int r = nums.length-1;
        while(true && r > l){
            // 边界处理
            if(nums[l] == target || nums[r] == target){
                return nums[l] == target ? l : r;
            }
            // 避免死循环
            if(r - l == 1){
                return -1;
            }

            // 计算中位索引mid和其对应的值
            if(nums[mid = (l + r)/2] == target){
                return mid;
            }


            if(nums[mid] > nums[l]){
                if(nums[l] < target && target < nums[mid]){
                    r = mid;
                }else if(target > nums[mid] || target < nums[r]){
                    l = mid;
                }else{
                    return -1;
                }
            }else{
                if(nums[mid] < target && target < nums[r]){
                    l = mid;
                }else if(nums[l] < target || target < nums[mid]){
                    r = mid;
                }else {
                    return -1;
                }
            }
        }

        if(nums[l] == target){
            return l;
        }

        return -1;
    }

}
