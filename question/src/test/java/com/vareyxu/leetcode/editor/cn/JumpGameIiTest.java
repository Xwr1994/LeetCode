package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameIiTest {
    @Test
    public void testSolution() {
        JumpGameIi.Solution solution = new JumpGameIi().new Solution();
        int[] input1 = new int[]{2,3,1,1,4};
        int[] input2 = new int[]{2,3,0,1,4};
        assertEquals(2, solution.jump(input1));
        assertEquals(2, solution.jump(input2));
    }
}