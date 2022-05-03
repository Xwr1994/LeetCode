//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1303 👎 0

package com.vareyxu.leetcode.editor.cn;

import com.vareyxu.leetcode.editor.cn.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
       Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }

    class Solution {
        public List<List<Integer>> levelOrderBfs(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> result = new ArrayList<>();

            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> tmp = new ArrayList<>();
                for (int i = 0; i < size; i ++) {
                    TreeNode node = queue.poll();
                    tmp.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                result.add(tmp);
            }
            return result;
        }

        public List<List<Integer>> levelOrderDfs(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }

            Map<Integer, List<Integer>> map = new HashMap<>();
            travel(1, root, map);

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i <= map.size(); i++) {
                result.add(map.get(i));
            }
            return result;
        }

        private void travel(int level, TreeNode node, Map<Integer,
                List<Integer>> result) {
            if (node == null) {
                return;
            }

            if (!result.containsKey(level)) {
                result.put(level, new ArrayList<>());
            }
            result.get(level).add(node.val);
            travel(level + 1, node.left, result);
            travel(level + 1, node.right, result);
        }
    }
}