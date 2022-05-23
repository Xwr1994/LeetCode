package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class NormalSortTest {
    @Test
    public void testSolutionChoose() {
        NormalSort.Solution solution = new NormalSort().new Solution();
        int[] input = new int[]{1,4,7,2,3,5,9,6,8};
        int[] expect = new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expect, solution.chooseSort(input));
    }

    @Test
    public void testSolutionInsert() {
        NormalSort.Solution solution = new NormalSort().new Solution();
        int[] input = new int[]{1,4,7,2,3,5,9,6,8};
        int[] expect = new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expect, solution.insertSort(input));
    }

    @Test
    public void testSolutionBubble() {
        NormalSort.Solution solution = new NormalSort().new Solution();
        int[] input = new int[]{1,4,7,2,3,5,9,6,8};
        int[] expect = new int[]{1,2,3,4,5,6,7,8,9};
        assertArrayEquals(expect, solution.bubbleSort(input));
    }
}