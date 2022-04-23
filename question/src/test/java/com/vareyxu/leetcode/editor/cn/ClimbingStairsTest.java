package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingStairsTest {
    @Test
    public void testSolution() {
        ClimbingStairs.Solution solution = new ClimbingStairs().new Solution();
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
    }
}