//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1431 👎 0

package com.vareyxu.leetcode.editor.cn;

import java.util.Arrays;

public class MajorityElement{
    public static void main(String[] args) {
       Solution solution = new MajorityElement().new Solution();
    }

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[(nums.length - 1) / 2];
    }

    public int majorityElementRce(int[] nums) {
        // 分治解法
        return rce(nums, 0, nums.length - 1);
    }

    public int rce(int[] nums, int start, int end) {
        // 1. 停止条件
        if (start == end) {
            return nums[start];
        }

        // 2. 分解成子问题
        int mid = (end - start) / 2 + start;
        int left = rce(nums, start, mid);
        int right = rce(nums, mid + 1, end);

        if (left == right) {
            return left;
        }

        int leftCount = getCount(nums, left, start, mid);
        int rightCount = getCount(nums, right, mid + 1, end);
        return leftCount > rightCount ? left : right;
    }

    private int getCount(int[] nums, int num, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}

}