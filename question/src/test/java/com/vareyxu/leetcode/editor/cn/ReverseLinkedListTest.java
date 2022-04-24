package com.vareyxu.leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {
    @Test
    public void testSolution1() {
        ReverseLinkedList.Solution solution = new ReverseLinkedList().new Solution();
        ReverseLinkedList.ListNode input = getInput();
        solution.reverseList1(input);
        assertEquals(input, getExpect());
    }

    @Test
    public void testSolution2() {
        ReverseLinkedList.Solution solution = new ReverseLinkedList().new Solution();
        ReverseLinkedList.ListNode input = getInput();
        solution.reverseList2(input);
        assertEquals(input, getExpect());
    }

    private ReverseLinkedList.ListNode getInput() {
        Map<Integer, ReverseLinkedList.ListNode> map = new LinkedHashMap<>();
        for (int i = 1; i <= 5; i++) {
            map.put(i, new ReverseLinkedList.ListNode(i, null));
        }
        for (Map.Entry<Integer, ReverseLinkedList.ListNode> entry : map.entrySet()) {
            ReverseLinkedList.ListNode curr = entry.getValue();
            curr.next = map.getOrDefault(entry.getKey() + 1, null);
        }
        return map.get(1);
    }

    private ReverseLinkedList.ListNode getExpect() {
        Map<Integer, ReverseLinkedList.ListNode> map = new LinkedHashMap<>();
        for (int i = 5; i >= 1; i--) {
            map.put(i, new ReverseLinkedList.ListNode(i, null));
        }
        for (Map.Entry<Integer, ReverseLinkedList.ListNode> entry : map.entrySet()) {
            ReverseLinkedList.ListNode curr = entry.getValue();
            curr.next = map.getOrDefault(entry.getKey() - 1, null);
        }
        return map.get(1);
    }
}