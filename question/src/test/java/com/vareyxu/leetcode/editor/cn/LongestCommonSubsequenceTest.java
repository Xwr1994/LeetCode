package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonSubsequenceTest {
    @Test
    public void testSolution() {
        LongestCommonSubsequence.Solution solution = new LongestCommonSubsequence().new Solution();
        assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, solution.longestCommonSubsequence("abc", "abc"));
        assertEquals(0, solution.longestCommonSubsequence("abc", "def"));
    }
}