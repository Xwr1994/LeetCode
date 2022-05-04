//给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。 
//
// 返回执行此操作后，grid 中最大的岛屿面积是多少？ 
//
// 岛屿 由一组上、下、左、右四个方向相连的 1 形成。 
//
// 
//
// 示例 1: 
//
// 
//输入: grid = [[1, 0], [0, 1]]
//输出: 3
//解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1, 1], [1, 0]]
//输出: 4
//解释: 将一格0变成1，岛屿的面积扩大为 4。 
//
// 示例 3: 
//
// 
//输入: grid = [[1, 1], [1, 1]]
//输出: 4
//解释: 没有0可以让我们变成1，面积依然为 4。 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 500 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 148 👎 0

package com.vareyxu.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland{
    public static void main(String[] args) {
       Solution solution = new MakingALargeIsland().new Solution();
    }

class Solution {
    public int largestIsland(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        // 第一次DFS，遍历陆地格子
        int result = 0;
        Map<Integer, Integer> indexArea = new HashMap<>();
        int index = 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, index);
                    indexArea.put(index, area);
                    index++;
                    result = Math.max(result, area);
                }
            }
        }

        // 若第一次遍历没发现陆地，则直接返回1
        if (indexArea.isEmpty()) {
            return 1;
        }

        // 第二次DFS，遍历海洋格子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = getNeighbor(grid, i, j);
                    if (set.size() == 0) {
                        continue;
                    }
                    int twoIsland = 1;
                    for (int value : set) {
                        twoIsland += indexArea.get(value);
                    }
                    result = Math.max(result, twoIsland);
                }
            }
        }
        return result;
    }

    public int dfs(int[][] grid, int r, int c, int index) {
        if (!isValid(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = index;

        return 1 + dfs(grid, r - 1, c, index) +
                dfs(grid, r + 1, c, index) +
                dfs(grid, r, c - 1, index) +
                dfs(grid, r, c + 1, index);
    }

    private boolean isValid(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c < grid[0].length;
    }

    private Set<Integer> getNeighbor(int[][] grid, int r, int c) {
        Set<Integer> result = new HashSet<>();
        if (r - 1 >= 0 && grid[r - 1][c] != 0) {
            result.add(grid[r - 1][c]);
        }
        if (r + 1 < grid.length && grid[r + 1][c] != 0) {
            result.add(grid[r + 1][c]);
        }
        if (c - 1 >= 0 && grid[r][c - 1] != 0) {
            result.add(grid[r][c - 1]);
        }
        if (c + 1 < grid[r].length && grid[r][c + 1] != 0) {
            result.add(grid[r][c + 1]);
        }
        return result;
    }
}

}