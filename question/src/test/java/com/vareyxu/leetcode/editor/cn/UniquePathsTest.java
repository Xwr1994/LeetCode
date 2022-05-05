package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsTest {
    @Test
    public void testSolution() {
        UniquePaths.Solution solution = new UniquePaths().new Solution();
        assertEquals(28, solution.uniquePaths(3, 7));
        assertEquals(3, solution.uniquePaths(3, 2));
    }
}