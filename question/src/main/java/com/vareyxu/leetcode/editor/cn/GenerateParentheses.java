//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2612 👎 0

package com.vareyxu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses{
    public static void main(String[] args) {
       Solution solution = new GenerateParentheses().new Solution();
    }

class Solution {
    public List<String> generateParenthesisDfs(int n) {
        // 深度优先搜索 + 剪枝
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs("", n, n, result);
        return result;
    }

    private void dfs(String str, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(str + "(", left - 1, right, result);
        }
        if (right > 0) {
            dfs(str + ")", left, right - 1, result);
        }
    }
}

}