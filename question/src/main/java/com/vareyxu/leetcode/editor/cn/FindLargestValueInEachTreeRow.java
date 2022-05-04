//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 186 👎 0

package com.vareyxu.leetcode.editor.cn;

import com.vareyxu.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindLargestValueInEachTreeRow{
    public static void main(String[] args) {
       Solution solution = new FindLargestValueInEachTreeRow().new Solution();
    }

class Solution {
    public List<Integer> largestValuesBfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(max, node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    public List<Integer> largestValuesDfs(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        dfs(root, 1, map);
        for (int i = 1; i <= map.size(); i++) {
            List<Integer> list = map.get(i);
            int max = Integer.MIN_VALUE;

            for (int value : list) {
                max = Math.max(max, value);
            }
            result.add(max);
        }
        return result;
    }

    private void dfs(TreeNode node, int level, Map<Integer, List<Integer>> map) {
        // 终止条件
        if (node == null) {
            return;
        }

        List<Integer> list = map.getOrDefault(level, new ArrayList<>());
        list.add(node.val);
        map.put(level, list);

        if (node.left != null) {
            dfs(node.left, level + 1, map);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, map);
        }
    }
}

}