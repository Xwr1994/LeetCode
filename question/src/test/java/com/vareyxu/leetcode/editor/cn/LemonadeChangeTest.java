package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class LemonadeChangeTest {
    @Test
    public void testSolution() {
        LemonadeChange.Solution solution = new LemonadeChange().new Solution();
        int[] input1 = new int[]{5,5,5,10,20};
        int[] input2 = new int[]{5,5,10,10,20};
        assertTrue(solution.lemonadeChange(input1));
        assertFalse(solution.lemonadeChange(input2));
    }
}