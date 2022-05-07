package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberOfIslandsTest {
    @Test
    public void testSolution() {
        NumberOfIslands.Solution solution = new NumberOfIslands().new Solution();
        char[][] input = new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        };
        assertEquals(3, solution.numIslands(input));
    }

    @Test
    public void testSolutionUnionFind() {
        NumberOfIslands.Solution solution = new NumberOfIslands().new Solution();
        char[][] input = new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        };
        assertEquals(3, solution.numIslandsByUnionFind(input));
    }
}