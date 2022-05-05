package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpGameTest {
    @Test
    public void testSolution() {
        JumpGame.Solution solution = new JumpGame().new Solution();
        int[] input1 = new int[]{2,3,1,1,4};
        int[] input2 = new int[]{3,2,1,0,4};
        assertTrue(solution.canJump(input1));
        assertFalse(solution.canJump(input2));
    }
}