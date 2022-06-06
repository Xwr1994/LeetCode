package com.vareyxu.leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RelativeSortArrayTest {
    @Test
    public void testSolution() {
        RelativeSortArray.Solution solution = new RelativeSortArray().new Solution();
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[]{2,1,4,3,9,6};
        int[] expect1 = new int[]{2,2,2,1,4,3,3,9,6,7,19};
        Assert.assertArrayEquals(expect1, solution.relativeSortArray(arr1, arr2));

        int[] arr3 = new int[]{28,6,22,8,44,17};
        int[] arr4 = new int[]{22,28,8,6};
        int[] expect2 = new int[]{22,28,8,6,17,44};
        Assert.assertArrayEquals(expect2, solution.relativeSortArray(arr3, arr4));
    }

}