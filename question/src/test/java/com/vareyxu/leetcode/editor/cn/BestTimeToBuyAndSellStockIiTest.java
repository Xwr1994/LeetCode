package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockIiTest {
    @Test
    public void testSolutionGreedy() {
        BestTimeToBuyAndSellStockIi.Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        int[] input1 = new int[]{7,1,5,3,6,4};
        int[] input2 = new int[]{1,2,3,4,5};
        int[] input3 = new int[]{7,6,4,3,1};
        assertEquals(7, solution.maxProfitGreedy(input1));
        assertEquals(4, solution.maxProfitGreedy(input2));
        assertEquals(0, solution.maxProfitGreedy(input3));
    }

    @Test
    public void testSolutionDp() {
        BestTimeToBuyAndSellStockIi.Solution solution = new BestTimeToBuyAndSellStockIi().new Solution();
        int[] input1 = new int[]{7,1,5,3,6,4};
        int[] input2 = new int[]{1,2,3,4,5};
        int[] input3 = new int[]{7,6,4,3,1};
        assertEquals(7, solution.maxProfitDp(input1));
        assertEquals(4, solution.maxProfitDp(input2));
        assertEquals(0, solution.maxProfitDp(input3));
    }
}