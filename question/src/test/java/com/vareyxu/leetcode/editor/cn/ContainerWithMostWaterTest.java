package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

public class ContainerWithMostWaterTest {
    @Test
    public void testSolution() {
        ContainerWithMostWater.Solution solution = new ContainerWithMostWater().new Solution();
        int result = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(result);
        assert result == 49;
    }
}