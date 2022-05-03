package com.vareyxu.leetcode.editor.cn.util;

import com.vareyxu.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * xxx
 *
 * @author: vareyxu
 * @create: 2022/5/3
 */
public class GenerateBinaryTree {

    public static TreeNode generateBinaryTreeByArray(Integer[] intArr) {
        return generateBinaryTreeByArray(intArr, 0);
    }

    private static TreeNode generateBinaryTreeByArray(Integer[] intArr, int num) {
        if (intArr == null || intArr.length == 0) {
            return null;
        }

        Integer value = intArr[num];
        if (value == null) {
            return null;
        }
        TreeNode root = new TreeNode(value);
        // 创建左子节点
        if (num * 2 + 1 < intArr.length) {
            root.left = generateBinaryTreeByArray(intArr, num * 2 + 1);
        }
        // 创建右子节点
        if (num * 2 + 2 < intArr.length) {
            root.right = generateBinaryTreeByArray(intArr, num * 2 + 2);
        }
        return root;
    }

    public static void treeToString(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        travelNode(treeNode, result);
        System.out.println(result);
    }

    private static void travelNode(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        travelNode(node.left, result);
        travelNode(node.right, result);
    }
}
