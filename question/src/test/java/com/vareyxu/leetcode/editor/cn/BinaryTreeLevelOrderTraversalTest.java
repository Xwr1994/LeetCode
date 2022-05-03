package com.vareyxu.leetcode.editor.cn;

import com.vareyxu.leetcode.editor.cn.common.TreeNode;
import com.vareyxu.leetcode.editor.cn.util.GenerateBinaryTree;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalTest {

    private List<List<Integer>> expect = new ArrayList<List<Integer>>() {
        {
            add(Collections.singletonList(3));
            add(Arrays.asList(9, 20));
            add(Arrays.asList(15, 7));
        }
    };

    @Test
    public void testSolutionBfs() {
        BinaryTreeLevelOrderTraversal.Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = GenerateBinaryTree.generateBinaryTreeByArray(arr);
        List<List<Integer>> result = solution.levelOrderBfs(treeNode);
        System.out.println(result);
        assertEquals(result, expect);
    }

    @Test
    public void testSolutionDfs() {
        BinaryTreeLevelOrderTraversal.Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = GenerateBinaryTree.generateBinaryTreeByArray(arr);
        List<List<Integer>> result = solution.levelOrderDfs(treeNode);
        System.out.println(result);
        assertEquals(result, expect);
    }
}