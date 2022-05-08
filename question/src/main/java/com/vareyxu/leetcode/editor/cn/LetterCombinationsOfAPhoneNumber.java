//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1882 👎 0

package com.vareyxu.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
       Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }

class Solution {
    private final Map<String, List<String>> numsMap = new HashMap<String, List<String>>() {
        {
            put("2", Arrays.asList("a", "b", "c"));
            put("3", Arrays.asList("d", "e", "f"));
            put("4", Arrays.asList("g", "h", "i"));
            put("5", Arrays.asList("j", "k", "l"));
            put("6", Arrays.asList("m", "n", "o"));
            put("7", Arrays.asList("p", "q", "r", "s"));
            put("8", Arrays.asList("t", "u", "v"));
            put("9", Arrays.asList("w", "x", "y", "z"));
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.equals("")) {
            return result;
        }

        recursion(digits, result, new StringBuilder());
        return result;
    }

    public void recursion(String digits, List<String> result, StringBuilder builder) {
        if (digits.equals("")) {
            result.add(builder.toString());
            return;
        }

        String current = digits.substring(0, 1);
        String subDigits = digits.substring(1);
        List<String> chars = numsMap.get(current);
        for (String ch : chars) {
            builder.append(ch);
            recursion(subDigits, result, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}

}