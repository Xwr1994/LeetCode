package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedArrayTest {
    @Test
    public void testSolution() {
        RemoveDuplicatesFromSortedArray.Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        int[] input = new int[]{1, 1, 2};
        int result = solution.removeDuplicates(input);
        int[] expect = new int[]{1, 2};
        assertEquals(2, result);
        for (int i = 0; i < 2; i++) {
            assertEquals(expect[i], input[i]);
        }
    }
}