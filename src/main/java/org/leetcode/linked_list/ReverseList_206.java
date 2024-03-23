package org.leetcode.linked_list;

import com.minmin.algorithmspass.charpter1_linklist.level1.ListNode;

public class ReverseList_206 {
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

    public ListNode reverseList(ListNode head) {
        // ListNode virtualHead = new ListNode();
        // ListNode curNode = head;
        // while (curNode != null && curNode.next != null) {
        //     virtualHead.next = curNode.next;
        //     curNode.next = curNode.next.next;
        //     virtualHead.next.next = curNode;
        //     curNode = curNode.next;
        // }
        // return virtualHead.next;

        //利用三个节点的位置关系进行位置迭代
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
