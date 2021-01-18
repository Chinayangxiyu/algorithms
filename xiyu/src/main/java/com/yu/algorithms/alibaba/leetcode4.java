package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-08 14:59
 */
public class leetcode4 {


    /**
     * nums1和nums2的总长度为size
     * 1、查找两个数组的中位数就是找到组合数组的第 size/2 个元素的值（size为奇数时为size/2;size为偶数时求 size/2 + size/2的平均值）。
     * 2、mid = size/2; 从头开始升序遍历nums1和nums2数组，直到找到第mid个元素；
     * 3、为了处理偶数长度的情况，需要缓存最后一次遍历的前一次获取的结果值，为了拿到这个结果，遍历的过程需要缓存上一次遍历的结果。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int mid = (nums1.length + nums2.length)/2;

        // 缓存上一次遍历的结果值
        int min = 0;
        // 当前遍历的值
        int max = 0;
        // nums1的索引位置
        int i = 0;
        // nums2的索引位置
        int j = 0;

        // 遍历 mid次
        while(mid >=0){
            min = max;// 缓存
            // 从nums1和nums2中找到当前应该遍历哪个元素，保证整理遍历数升序的
            if(i < nums1.length && j < nums2.length){
                if(nums1[i] > nums2[j]){
                    max = nums2[j++];
                }else{
                    max = nums1[i++];
                }

                //如果某一个数组已经遍历结束，则直接递增遍历另一个元素
            }else {
                if(i == nums1.length){
                    max = nums2[j++];
                }else {
                    max = nums1[i++];

                }
            }

            mid--;
        }

        // 偶数计算平均值
        if(((nums1.length + nums2.length) & 1) ==0){
            return (min + max)/2.0d;
        }


        // 奇数直接返回
        return max;
    }
}
