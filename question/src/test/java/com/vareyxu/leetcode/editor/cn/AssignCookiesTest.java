package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class AssignCookiesTest {
    @Test
    public void testSolution() {
        AssignCookies.Solution solution = new AssignCookies().new Solution();
        int[] g1 = new int[]{1,2,3};
        int[] s1 = new int[]{1,1};
        int[] g2 = new int[]{1,2};
        int[] s2 = new int[]{1,2,3};
        assertEquals(1, solution.findContentChildren(g1, s1));
        assertEquals(2, solution.findContentChildren(g2, s2));
    }
}