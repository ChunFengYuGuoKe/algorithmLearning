package com.minmin.algorithmspass.charpter2_reverselist.level2.topic2_2两两反转;

public class ReverseListTwoGroup {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        ListNode nodeA = initLinkedList(a);

        ListNode d = null;
        //d=swapPairs(nodeA);
        d=swapPairsByMyself2(nodeA);

        System.out.println(toString(d));

    }

    /**
     * 自己写的
     * @param head
     * @return
     */
    public static  ListNode swapPairsByMyself(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while(cur != null && cur.next != null && cur.next.next != null) {
            ListNode pre = cur.next;
            ListNode post = cur.next.next;
            pre.next = post.next;
            post.next = pre;
            cur.next = post;
            cur = cur.next.next;
        }
        return dummyNode.next;
    }

    public static  ListNode swapPairsByMyself2(ListNode head) {
        ListNode pre = head;
        while(pre.next != null) {
            ListNode post = pre.next;
            ListNode next = post.next;
            pre.next = post.next;
            post.next = pre;
            pre = next;
        }
        return head;
    }


    /**
     * 方法3：直接根据两个指针的情况来设置
     * @param head
     * @return
     */
    public static  ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;
        }
        return dummyHead.next;
    }
    /**
     * 初始化链表
     *
     * @param array
     * @return
     */
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

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
