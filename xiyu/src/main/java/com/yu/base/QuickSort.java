package com.yu.base;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-14 13:45
 */
public class QuickSort {


    public static void main(String[] args){


        int[] array = new int[]{6,5,4,3,2,1,0};
        QuickSort q = new QuickSort();
        q.sort(array, 0, array.length-1);
        System.out.println(array.toString());
    }


    private int cur;
    public void sort(int[] nums, int left , int right){

        if(left >= right){
            return;
        }

        // 缓存起止索引位置
        int i = left;
        int j = right;
        // 标记最右元素为当前比较基准值
        cur = nums[j];
        // 指针碰撞以前一直遍历
        while(left < right){
            // 基准值为最右边的元素，那么必须从左边开始去遍历；
            // 因为从哪边开始，最后就会从哪边结束；结束的时候需要交换cur值和最后指针指向的值；
            // 如果不满足这个条件，会将比cur小的值替换到右边、或比cur大的值替换到左边这种错误操作
            left = leftSort(nums, left, right);
            right = rightSort(nums, left, right);
        }

        // 替换基准值和最终指针指向的值，使用j
        nums[j] = nums[left];
        nums[left] = cur;

        // 二分继续排序
        sort(nums, i, left-1);
        sort(nums, left+1, j);


    }


    private int leftSort(int[] nums, int left , int right){

        for(int i = left; i < right; i++){
            if(nums[i] > cur){
                return i;
            }
        }

        return right;

    }

    private int rightSort(int[] nums, int left , int right){

        for(int i = right; i > left; i--){
            if(nums[i] < cur){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                return i;
            }
        }

        return left;

    }

}
