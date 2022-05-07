package com.vareyxu.leetcode.editor.cn.common;

import java.util.Arrays;

/**
 * xxx
 *
 * @author: vareyxu
 * @create: 2022/5/7
 */
public class UnionFind {
    private final int[] parent;
    private final int[] rank;
    private int count;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public UnionFind(int n, int count) {
        this.count = count;
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(rank, 1);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        // 路径压缩
        parent[n] = find(parent[n]);
        return parent[n];
    }

    public void merge(int x, int y) {
        int i = find(x);
        int j = find(y);
        if (i == j) {
            return;
        }
        if (rank[i] > rank[j]) {
            parent[j] = i;
        } else if (rank[j] > rank[i]) {
            parent[i] = j;
        } else {
            parent[j] = i;
            rank[i]++;
        }
        count--;
    }

    public int getCount() {
        return this.count;
    }
}
