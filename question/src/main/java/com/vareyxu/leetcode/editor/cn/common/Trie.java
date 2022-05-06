package com.vareyxu.leetcode.editor.cn.common;

/**
 * xxx
 *
 * @author: vareyxu
 * @create: 2022/5/6
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        return this.root;
    }

    /**
     * 给字典树插入一个字符串
     * @param word
     */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    /**
     * 在字典树中查找字符串
     * @param word
     */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.containsKey(ch)) {
                node = node.get(ch);
            } else {
                return null;
            }
        }
        return node;
    }
}
