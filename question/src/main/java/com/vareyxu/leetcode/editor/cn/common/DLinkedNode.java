package com.vareyxu.leetcode.editor.cn.common;

/**
 * 双向链表
 *
 * @author: vareyxu
 * @create: 2022/5/11
 */
public class DLinkedNode {
    public int key;
    public int value;
    public DLinkedNode prev;
    public DLinkedNode next;

    public DLinkedNode() {

    }

    public DLinkedNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
