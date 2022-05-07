package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class SurroundedRegionsTest {
    @Test
    public void testSolutionDfs() {
        SurroundedRegions.Solution solution = new SurroundedRegions().new Solution();
        char[][] input = new char[][]{
                new char[]{'X','X','X','X'},
                new char[]{'X','O','O','X'},
                new char[]{'X','X','O','X'},
                new char[]{'X','O','X','X'}
        };
        char[][] expect = new char[][]{
                new char[]{'X','X','X','X'},
                new char[]{'X','X','X','X'},
                new char[]{'X','X','X','X'},
                new char[]{'X','O','X','X'}
        };
        solution.solve(input, false);
        assertArrayEquals(expect, input);
    }

    @Test
    public void testSolutionBfs() {
        SurroundedRegions.Solution solution = new SurroundedRegions().new Solution();
        char[][] input = new char[][]{
                new char[]{'O','O'},
                new char[]{'O','O'}
        };
        char[][] expect = new char[][]{
                new char[]{'O','O'},
                new char[]{'O','O'}
        };
        solution.solve(input, true);
        assertArrayEquals(expect, input);
    }

    @Test
    public void testSolutionUnion() {
        SurroundedRegions.Solution solution = new SurroundedRegions().new Solution();
        char[][] input1 = new char[][]{
                new char[]{'O','X','X','O','X'},
                new char[]{'X','O','O','X','O'},
                new char[]{'X','O','X','O','X'},
                new char[]{'O','X','O','O','O'},
                new char[]{'X','X','O','X','O'}
        };
        char[][] expect1 = new char[][]{
                new char[]{'O','X','X','O','X'},
                new char[]{'X','X','X','X','O'},
                new char[]{'X','X','X','O','X'},
                new char[]{'O','X','O','O','O'},
                new char[]{'X','X','O','X','O'}
        };
        char[][] input2 = new char[][]{
                new char[]{'O','O','O'},
                new char[]{'O','O','O'},
                new char[]{'O','O','O'}
        };
        char[][] expect2 = new char[][]{
                new char[]{'O','O','O'},
                new char[]{'O','O','O'},
                new char[]{'O','O','O'}
        };
//        solution.solveUnionFind(input1);
//        assertArrayEquals(expect1, input1);
        solution.solveUnionFind(input2);
        assertArrayEquals(expect2, input2);
    }
}