package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniquePathsIiTest {
    @Test
    public void testSolution() {
        UniquePathsIi.Solution solution = new UniquePathsIi().new Solution();
        int[][] input1 = new int[][]{
                new int[]{0,0,0},
                new int[]{0,1,0},
                new int[]{0,0,0}
        };
        int[][] input2 = new int[][]{
                new int[]{0,1},
                new int[]{0,0}
        };
        assertEquals(2, solution.uniquePathsWithObstacles(input1));
        assertEquals(1, solution.uniquePathsWithObstacles(input2));
    }
}