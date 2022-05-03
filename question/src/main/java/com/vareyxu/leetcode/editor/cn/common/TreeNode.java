package com.vareyxu.leetcode.editor.cn.common;

/**
 * xxx
 *
 * @author: vareyxu
 * @create: 2022/5/3
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
