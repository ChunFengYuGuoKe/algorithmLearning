package org.leetcode.linked_list;

import com.minmin.algorithmspass.charpter1_linklist.level1.ListNode;

public class GetIntersectionNode_160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    // 主要是利用了链表的特点，利用了结构导致的长度上的特点

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // // 1.根据链表的结构长度来做
        if(headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

        // 2.用hashset来判断
        // Set<ListNode> visited = new HashSet<ListNode>();
        // ListNode temp = headA;
        // while (temp != null) {
        //     visited.add(temp);
        //     temp = temp.next;
        // }

        // temp = headB;
        // while (temp != null) {
        //     if (visited.contains(temp)) {
        //         return temp;
        //     }
        //     temp = temp.next;
        // }
        // return null;
    }
}
