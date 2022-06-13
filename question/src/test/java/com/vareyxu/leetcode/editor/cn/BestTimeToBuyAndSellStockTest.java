package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void testSolution() {
        BestTimeToBuyAndSellStock.Solution solution = new BestTimeToBuyAndSellStock().new Solution();
        int[] input1 = new int[]{7,1,5,3,6,4};
        int[] input2 = new int[]{7,6,4,3,1};
        assertEquals(5, solution.maxProfit(input1));
        assertEquals(0, solution.maxProfit(input2));
    }
}