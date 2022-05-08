package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class NQueensTest {
    @Test
    public void testSolution() {
        NQueens.Solution solution = new NQueens().new Solution();
        List<List<String>> expect1 = new ArrayList<List<String>>() {
            {
                add(Arrays.asList(".Q..","...Q","Q...","..Q."));
                add(Arrays.asList("..Q.","Q...","...Q",".Q.."));
            }
        };
        List<List<String>> expect2 = new ArrayList<List<String>>() {
            {
                add(Collections.singletonList("Q"));
            }
        };
        assertEquals(expect1, solution.solveNQueens(4));
        assertEquals(expect2, solution.solveNQueens(1));
    }
}