package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class WordSearchIiTest {
    @Test
    public void testSolution() {
        WordSearchIi.Solution solution = new WordSearchIi().new Solution();
        char[][] charInput1 = new char[][] {
                new char[]{'o','a','a','n'},
                new char[]{'e','t','a','e'},
                new char[]{'i','h','k','r'},
                new char[]{'i','f','l','v'}
        };
        String[] wordInput1 = new String[]{"oath","pea","eat","rain"};
        assertEquals(Arrays.asList("oath","eat"), solution.findWords(charInput1, wordInput1));

        char[][] charInput2 = new char[][] {
                new char[]{'a','b'},
                new char[]{'c','d'}
        };
        String[] wordInput2 = new String[]{"abcd"};
        assertEquals(new ArrayList<>(), solution.findWords(charInput2, wordInput2));

        char[][] charInput3 = new char[][] {
                new char[]{'a','a'}
        };
        String[] wordInput3 = new String[]{"aaa"};
        assertEquals(new ArrayList<>(), solution.findWords(charInput3, wordInput3));
    }
}