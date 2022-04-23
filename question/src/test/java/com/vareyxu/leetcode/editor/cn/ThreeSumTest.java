package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumTest {
    @Test
    public void testSolution() {
        ThreeSum.Solution solution = new ThreeSum().new Solution();
        List<List<Integer>> result = solution.threeSum(new int[]{-1, 0, 1, 2, -1, 4});
        System.out.println(result);

        List<List<Integer>> expect = new ArrayList<List<Integer>>(){
            {
                add(Arrays.asList(-1, -1, 2));
                add(Arrays.asList(-1, 0, 1));
            }
        };
        assertEquals(expect, result);
    }
}