package com.vareyxu.leetcode.editor.cn;

/**
 * 高级排序算法：快速、归并、堆排序
 *
 * @author: vareyxu
 * @create: 2022/5/31
 */
public class AdvanceSort {
    public static void main(String[] args) {
        Solution solution = new AdvanceSort().new Solution();
    }

    class Solution {
        // 快速排序：选取一个pivot点，将小于该位置值的数据放左边，大于的放右边，并继续将左右两边进行快排
        public int[] quickSort(int[] nums) {
            if (nums == null && nums.length == 0) {
                return nums;
            }
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int start, int end) {
            if (end <= start) {
                return;
            }
            int pivot = partition(nums, start, end);
            quickSort(nums, start, pivot - 1);
            quickSort(nums, pivot + 1, end);
        }

        private int partition(int[] nums, int start, int end) {
            int counter = start;
            int pivot = end;
            for (int i = start; i < end; i++) {
                if (nums[i] < nums[pivot]) {
                    swap(nums, i, counter);
                    counter++;
                }
            }
            swap(nums, counter, pivot);
            return counter;
        }

        // 归并排序：从中间点开始，分别归并排序左数组、右数组，并将左右数组合并
        public int[] mergeSort(int[] nums) {
            if (nums == null || nums.length == 0) {
                return nums;
            }
            mergeSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void mergeSort(int[] nums, int start, int end) {
            if (start == end) {
                return;
            }

            int mid = (start + end) >> 1;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, mid, start, end);
        }

        private void merge(int[] nums, int mid, int left, int right) {
            int[] temp = new int[right - left + 1];
            int i = left;
            int j = mid + 1;
            int index = 0;
            while (i <= mid && j <= right) {
                temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
            }
            while (i <= mid) {
                temp[index++] = nums[i++];
            }
            while (j <= right) {
                temp[index++] = nums[j++];
            }

            for (int a = 0; a < temp.length; a++) {
                nums[left + a] = temp[a];
            }
        }

        // 堆排序：将数组转化为小顶堆保存，遍历堆每次取最上面的元素
        // 左节点：2*i+1，右节点：2*i+2，父节点：(i-1)/2
        public int[] heapSort(int[] nums) {
            if (nums == null || nums.length == 0) {
                return nums;
            }

            // 将数组转为大顶堆
            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                heapify(nums, nums.length, i);
            }

            // 从数组的最后一个元素开始遍历，依次将堆顶元素放最后，并调整n-1个节点的堆
            for (int i = nums.length - 1; i >= 0; i--) {
                swap(nums, 0, i);
                heapify(nums, i, 0);
            }
            return nums;
        }

        private void heapify(int[] nums, int length, int i) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largest = i;

            if (left < length && nums[left] > nums[largest]) {
                largest = left;
            }
            if (right < length && nums[right] > nums[largest]) {
                largest = right;
            }

            if (largest != i) {
                swap(nums, i, largest);
                heapify(nums, length, largest);
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
