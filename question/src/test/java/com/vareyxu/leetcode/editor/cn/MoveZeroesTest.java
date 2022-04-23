package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MoveZeroesTest {
    @Test
    public void testSolution1() {
        MoveZeroes.Solution solution = new MoveZeroes().new Solution();
        int[] testArr = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes1(testArr);
        System.out.println(Arrays.toString(testArr));
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, testArr);
    }

    @Test
    public void testSolution2() {
        MoveZeroes.Solution solution = new MoveZeroes().new Solution();
        int[] testArr = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes2(testArr);
        System.out.println(Arrays.toString(testArr));
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, testArr);
    }
}