package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {
    @Test
    public void testSolutionBfs() {
        GenerateParentheses.Solution solution = new GenerateParentheses().new Solution();
        List<String> expect = new ArrayList<String>() {
            {
                add("((()))");
                add("(()())");
                add("(())()");
                add("()(())");
                add("()()()");
            }
        };
        assertEquals(expect, solution.generateParenthesisDfs(3));
    }
}