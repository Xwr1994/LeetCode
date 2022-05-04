package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class MakingALargeIslandTest {
    @Test
    public void testSolution() {
        MakingALargeIsland.Solution solution = new MakingALargeIsland().new Solution();
        int[][] inputOne = new int[][]{
                new int[]{1,0},
                new int[]{0,1}
        };
        int[][] inputTwo = new int[][]{
                new int[]{1,1},
                new int[]{1,0}
        };
        int[][] inputThree = new int[][]{
                new int[]{1,1},
                new int[]{1,1}
        };
        int[][] inputFour = new int[][]{
                new int[]{0,0},
                new int[]{0,1}
        };
        assertEquals(3, solution.largestIsland(inputOne));
        assertEquals(4, solution.largestIsland(inputTwo));
        assertEquals(4, solution.largestIsland(inputThree));
        assertEquals(2, solution.largestIsland(inputFour));
    }
}