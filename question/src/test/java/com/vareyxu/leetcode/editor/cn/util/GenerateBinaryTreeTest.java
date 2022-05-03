package com.vareyxu.leetcode.editor.cn.util;

import com.vareyxu.leetcode.editor.cn.common.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateBinaryTreeTest {
    @Test
    public void testGenerate() {
        Integer[] arr = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = GenerateBinaryTree.generateBinaryTreeByArray(arr);
        GenerateBinaryTree.treeToString(treeNode);
    }
}