package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.*;

public class MajorityElementTest {
    @Test
    public void testSolution() {
        MajorityElement.Solution solution = new MajorityElement().new Solution();
        int[] input1 = new int[]{3,2,3};
        int[] input2 = new int[]{2,2,1,1,1,2,2};
        assertEquals(3, solution.majorityElement(input1));
        assertEquals(2, solution.majorityElement(input2));
    }

    @Test
    public void testSolutionRce() {
        MajorityElement.Solution solution = new MajorityElement().new Solution();
        int[] input1 = new int[]{3,2,3};
        int[] input2 = new int[]{2,2,1,1,1,2,2};
        assertEquals(3, solution.majorityElementRce(input1));
        assertEquals(2, solution.majorityElementRce(input2));
    }
}