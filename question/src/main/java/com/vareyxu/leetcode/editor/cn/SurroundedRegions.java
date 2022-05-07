//给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充
//。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O",
//"X","X"]]
//输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
//解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都
//会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
// 
//
// 示例 2： 
//
// 
//输入：board = [["X"]]
//输出：[["X"]]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 为 'X' 或 'O' 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 789 👎 0

package com.vareyxu.leetcode.editor.cn;

import com.vareyxu.leetcode.editor.cn.common.UnionFind;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions{
    public static void main(String[] args) {
       Solution solution = new SurroundedRegions().new Solution();
    }

class Solution {
    public void solve(char[][] board, boolean isBfs) {
        if (board == null || board.length == 0) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isEdge = i == 0 || j == 0
                        || i == board.length - 1 || j == board[i].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    if (isBfs) {
                        bfs(board, i, j);
                    } else {
                        dfs(board, i ,j);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solveUnionFind(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int dummyNode = board.length * board[0].length;
        UnionFind unionFind = new UnionFind(dummyNode + 1);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    boolean isEdge = i == 0 || j == 0
                            || i == board.length - 1 || j == board[i].length - 1;
                    if (isEdge) {
                        unionFind.merge(dummyNode, i * board[i].length + j);
                    } else {
                        if (board[i - 1][j] == 'O') {
                            unionFind.merge((i - 1) * board[i].length + j,
                                    i * board[i].length + j);
                        }
                        if (i + 1 < board.length && board[i + 1][j] == 'O') {
                            unionFind.merge(i * board[i].length + j,
                                    (i + 1) * board[i].length + j);
                        }
                        if (board[i][j - 1] == 'O') {
                            unionFind.merge(i * board[i].length + j - 1,
                                    i * board[i].length + j);
                        }
                        if (j + 1 < board.length && board[i][j + 1] == 'O') {
                            unionFind.merge(i * board[i].length + j,
                                    i * board[i].length + j + 1);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (unionFind.find(i * board[i].length + j) == unionFind.find(dummyNode)) {
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }

    private int node(int i, int j, int cols) {
        return i * cols + j;
    }

    private void bfs(char[][] board, int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(i, j));
        board[i][j] = '#';
        while (!queue.isEmpty()) {
            Pos current = queue.poll();
            if (current.i - 1 >= 0 && board[current.i - 1][current.j] == 'O') {
                queue.offer(new Pos(current.i - 1, current.j));
                board[current.i - 1][current.j] = '#';
            }
            if (current.i + 1 < board.length && board[current.i + 1][current.j] == 'O') {
                queue.offer(new Pos(current.i + 1, current.j));
                board[current.i + 1][current.j] = '#';
            }
            if (current.j - 1 >= 0 && board[current.i][current.j - 1] == 'O') {
                queue.offer(new Pos(current.i, current.j - 1));
                board[current.i][current.j - 1] = '#';
            }
            if (current.j + 1 < board[current.i].length
                    && board[current.i][current.j + 1] == 'O') {
                queue.offer(new Pos(current.i, current.j + 1));
                board[current.i][current.j + 1] = '#';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        // 边界条件退出
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }
        // 递归终止退出
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';

        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}
}

class Pos {
    int i;
    int j;
    Pos(int i, int j) {
        this.i = i;
        this.j = j;
    }
}