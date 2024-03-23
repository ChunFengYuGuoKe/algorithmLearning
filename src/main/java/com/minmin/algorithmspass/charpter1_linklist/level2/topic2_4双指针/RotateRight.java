package com.minmin.algorithmspass.charpter1_linklist.level2.topic2_4双指针;

/**
 * Leetcode61.旋转数组
 */
public class RotateRight {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode nodeA = initLinkedList(a);
        ListNode node = rotate(nodeA, 2);
        System.out.println(toString(node));
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        System.out.println(len);
        if (k % len == 0) {
            return temp;
        }
        while ((k % len) > 0) {
            k--;
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        fast.next = temp;
        return res;
    }

    /**
     * 输出链表
     *
     * @param head 头节点
     */
    public static String toString(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val).append("\t");
            current = current.next;
        }
        return sb.toString();
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

    /**
     * 自己写的
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotate(ListNode head, int k) {
        if(k == 0 || head == null) {
            return head;
        }
        ListNode node = head;
        //这里length初始化为1是不对的，因为实际上算上null一共有n+1个节点，
        //也就需要走n步才能走到尾部，不需要初始化为1来补偿
        int length = 1;
        while (node != null) {
            node = node.next;
            length++;
        }
        System.out.println(length);
        k = k % length;

        ListNode fast = head;
        ListNode slow = head;
        while(k != 0) {
            fast = fast.next;
            k--;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //我在这里犯了个错误，误把fast节点当成最后的头节点了，其实是因为测试的例子不好，我的k只有1
        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
    }
}
