package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class IslandPerimeterTest {
    @Test
    public void testSolution() {
        IslandPerimeter.Solution solution = new IslandPerimeter().new Solution();
        int[][] input = new int[][]{
                new int[]{0,1,0,0},
                new int[]{1,1,1,0},
                new int[]{0,1,0,0},
                new int[]{1,1,0,0}
        };
        assertEquals(16, solution.islandPerimeter(input));
    }
}