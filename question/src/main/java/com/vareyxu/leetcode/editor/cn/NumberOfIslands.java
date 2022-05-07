//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1703 👎 0

package com.vareyxu.leetcode.editor.cn;

import com.vareyxu.leetcode.editor.cn.common.UnionFind;

public class NumberOfIslands{
    public static void main(String[] args) {
       Solution solution = new NumberOfIslands().new Solution();
    }

class Solution {
    public int numIslands(char[][] grid) {
        // DFS深度优先搜索
        if (grid.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    public int numIslandsByUnionFind(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                }
            }
        }
        int size = grid.length * grid[0].length;
        int n = grid[0].length;
        UnionFind unionFind = new UnionFind(size, count);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';

                    if (i+1 < grid.length && grid[i+1][j] == '1') {
                        unionFind.merge(i*n+j, (i+1)*n+j);
                    }
                    if (i-1 >= 0 && grid[i-1][j] == '1') {
                        unionFind.merge(i*n+j, (i-1)*n+j);
                    }
                    if (j+1 < grid[0].length && grid[i][j+1] == '1') {
                        unionFind.merge(i*n+j, i*n+j+1);
                    }
                    if (j-1 >= 0 && grid[i][j-1] == '1') {
                        unionFind.merge(i*n+j, i*n+j-1);
                    }
                }
            }
        }
        return unionFind.getCount();
    }

    public void dfs(char[][]grid, int r, int c) {
        if (!isValid(grid, r, c)) {
            return;
        }
        if (grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '2';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    private boolean isValid(char[][]grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }
}

}