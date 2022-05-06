package com.vareyxu.leetcode.editor.cn.common;

/**
 * xxx
 *
 * @author: vareyxu
 * @create: 2022/5/6
 */
public class TrieNode {

    private final int R = 26;
    private final TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}
