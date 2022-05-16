package com.vareyxu.leetcode.editor.cn;

/**
 * 基础排序算法：选择，插入，冒泡
 *
 * @author: vareyxu
 * @create: 2022/5/11
 */
public class NormalSort {
    public static void main(String[] args) {
        Solution solution = new NormalSort().new Solution();
    }

    class Solution {
        public int[] chooseSort(int[] nums) {
            int start = 0;
            for (int i = start; i < nums.length; i++) {
                int min = Integer.MAX_VALUE;
                int minIndex = 0;
                for (int j = start; j < nums.length; j++) {
                    if (nums[j] < min) {
                        min = nums[j];
                        minIndex = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
                start++;
            }
            return nums;
        }

        public void insertSort(int[] nums) {

        }

        public void bubbleSort(int[] nums) {

        }
    }
}

