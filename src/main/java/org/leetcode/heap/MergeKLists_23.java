package org.leetcode.heap;

import com.minmin.algorithmspass.charpter1_linklist.level1.ListNode;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 这道题还可以用归并排序等多种方法来做
 */
public class MergeKLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        // 首先依然是进行防御性编程
        if (lists == null || lists.length == 0) return null;

        // 创建堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);
        // 初始化堆
        for (int i = 0; i < lists.length; i++) {
            queue.offer(lists[i]);
        }

        // 创建新的头尾节点
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // 循环向链表中插入元素
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            queue.offer(node.next);
            tail = tail.next;
        }

        // 返回排好序的链表
        return dummy.next;
    }
}
