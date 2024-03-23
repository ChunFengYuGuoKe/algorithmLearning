package com.minmin.algorithmspass.charpter1_linklist.level2.topic2_4双指针;

/**
 * 寻找链表中间结点
 */
public class MiddleNode {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6};
        ListNode nodeA = initLinkedList(a);
        ListNode middle = middle(nodeA);
        System.out.println(middle.val);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            //这里为什么还要用一个pre？不符合题意错了
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return pre;
    }


    private static ListNode initLinkedList(int[] array) {
        ListNode head = null, cur = null;

        for (int i = 0; i < array.length; i++) {
            ListNode newNode = new ListNode(array[i]);
            newNode.next = null;
            if (i == 0) {
                head = newNode;
                cur = head;
            } else {
                cur.next = newNode;
                cur = newNode;
            }
        }
        return head;
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode middle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
