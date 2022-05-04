package com.vareyxu.leetcode.editor.cn;

import com.vareyxu.leetcode.editor.cn.common.TreeNode;
import com.vareyxu.leetcode.editor.cn.util.GenerateBinaryTree;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FindLargestValueInEachTreeRowTest {

    private List<Integer> expect = Arrays.asList(1, 3, 9);

    @Test
    public void testSolutionBfs() {
        FindLargestValueInEachTreeRow.Solution solution = new FindLargestValueInEachTreeRow().new Solution();
        TreeNode root = GenerateBinaryTree.generateBinaryTreeByArray(new Integer[]{1,3,2,5,3,null,9});
        assertEquals(expect, solution.largestValuesBfs(root));
    }

    @Test
    public void testSolutionDfs() {
        FindLargestValueInEachTreeRow.Solution solution = new FindLargestValueInEachTreeRow().new Solution();
        TreeNode root = GenerateBinaryTree.generateBinaryTreeByArray(new Integer[]{1,3,2,5,3,null,9});
        assertEquals(expect, solution.largestValuesDfs(root));
    }
}