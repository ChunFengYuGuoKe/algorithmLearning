package org.leetcode.linked_list;

import com.minmin.algorithmspass.charpter1_linklist.level1.ListNode;

public class SsPalindrome_234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 这两个时静态存储的，不用于遍历
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);

        // 新定义引用用于遍历
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;


        // 同时满足两个条件时继续遍历
        while(result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        firstHalfEnd.next = reverse(secondHalfStart);
        return result;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    // 怎样保证前面一半后面一半的？在slow和fast出发时就已经占用了一个位置的情况下
    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
