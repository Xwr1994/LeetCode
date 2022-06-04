package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdvanceSortTest {
    @Test
    public void testSolutionChoose() {
        AdvanceSort.Solution solution = new AdvanceSort().new Solution();
        int[] input = new int[]{1,4,7,2,3,5,9,6,8};
        int[] expect = new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expect, solution.quickSort(input));
    }

    @Test
    public void testSolutionMerge() {
        AdvanceSort.Solution solution = new AdvanceSort().new Solution();
        int[] input = new int[]{1,4,7,2,3,5,9,6,8};
        int[] expect = new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expect, solution.mergeSort(input));
    }

    @Test
    public void testSolutionHeap() {
        AdvanceSort.Solution solution = new AdvanceSort().new Solution();
        int[] input = new int[]{1,4,7,2,3,5,9,6,8};
        int[] expect = new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expect, solution.heapSort(input));
    }
}