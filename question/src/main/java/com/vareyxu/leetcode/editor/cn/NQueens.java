//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1321 👎 0

package com.vareyxu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens{
    public static void main(String[] args) {
       Solution solution = new NQueens().new Solution();
    }

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        int[] queues = new int[n];
        Arrays.fill(queues, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();

        recursion(queues, n, 0, columns, pie, na, result);
        return result;
    }

    private void recursion(int[] queues, int n, int row, Set<Integer> columns,
                          Set<Integer> pie, Set<Integer> na, List<List<String>> result) {
        if (row == n) {
            result.add(generateResult(queues, n));
            return;
        }

        for (int i = 0; i < n; i ++) {
            if (columns.contains(i)) {
                continue;
            }
            if (pie.contains(row + i)) {
                continue;
            }
            if (na.contains(row - i)) {
                continue;
            }

            queues[row] = i;
            columns.add(i);
            pie.add(row + i);
            na.add(row - i);
            recursion(queues, n, row + 1, columns, pie, na, result);

            // 回溯时清理本层记录
            queues[row] = -1;
            columns.remove(i);
            pie.remove(row + i);
            na.remove(row - i);
        }
    }

    private List<String> generateResult(int[] queues, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] ch = new char[n];
            Arrays.fill(ch, '.');
            ch[queues[i]] = 'Q';
            result.add(new String(ch));
        }
        return result;
    }
}

}