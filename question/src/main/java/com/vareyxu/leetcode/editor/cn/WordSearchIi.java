//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 655 👎 0

package com.vareyxu.leetcode.editor.cn;

import com.vareyxu.leetcode.editor.cn.common.Trie;
import com.vareyxu.leetcode.editor.cn.common.TrieNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchIi{
    public static void main(String[] args) {
       Solution solution = new WordSearchIi().new Solution();
    }

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // DFS + 字典树
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<String> result = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        int[][] mem = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, mem, i, j, trie.getRoot(), result, builder);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, int[][] mem, int i, int j,
                        TrieNode node, Set<String> result, StringBuilder builder) {
        // 边界条件退出
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        // 重复递归退出
        if (mem[i][j] != 0) {
            return;
        }
        // 递归不满足退出
        if (!node.containsKey(board[i][j])) {
            return;
        }

        mem[i][j]++;
        builder.append(board[i][j]);
        TrieNode nextNode = node.get(board[i][j]);
        if (nextNode.isEnd()) {
            result.add(builder.toString());
        }

        dfs(board, mem, i + 1, j, nextNode, result, builder);
        dfs(board, mem, i - 1, j, nextNode, result, builder);
        dfs(board, mem, i, j + 1, nextNode, result, builder);
        dfs(board, mem, i, j - 1, nextNode, result, builder);

        // 清理
        mem[i][j] = 0;
        builder.deleteCharAt(builder.length() - 1);
    }
}

}