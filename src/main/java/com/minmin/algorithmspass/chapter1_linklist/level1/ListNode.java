package com.minmin.algorithmspass.chapter1_linklist.level1;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int value) {
        val = value;
        next = null;
    }

    /**
     * 遍历获取链表长度
     * @param head 头节点
     * @return 链表长度
     */
    public static int getListLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 插入节点
     * @param head 头节点
     * @param nodeInsert 待插入节点
     * @param position 插入位置
     * @return 插入后的头节点
     */
    public static ListNode insertNode(ListNode head, ListNode nodeInsert, int position) {
        if (head == null) {
            //如果头节点为空，直接返回待插入节点
            return nodeInsert;
        }

        int size = getListLength(head);
        //假如head位置为1的写法
        if(position > size+1 || position < 1) {
            System.out.println("位置参数越界");
            return head;
        }

        //表头插入
        if(position == 1) {
            nodeInsert.next = head;
            head = nodeInsert;
            return head;
        }

        ListNode curNode = head;
        int count = 1;
        while(count < position - 1) {
            curNode = curNode.next;
            count++;
        }
        nodeInsert.next = curNode.next;
        curNode.next = nodeInsert;


        //假如head位置为0的写法
        /*if(position > size || position < 0) {
            System.out.println("位置参数越界");
            return head;
        }
        if(position == 0) {
            nodeInsert.next = head;
            head = nodeInsert;
            return head;
        }

        ListNode curNode = head;
        int count = 0;
        while(count < position - 1) {
            curNode = curNode.next;
            count++;
        }
        nodeInsert.next = curNode.next;
        curNode.next = nodeInsert;*/

        return head;
    }


    /**
     * 删除节点
     * @param head 头节点
     * @param position 删除位置
     * @return 删除后的头节点
     */
    public static ListNode deleteNode(ListNode head, int position) {
        if (head == null) {
            return null;
        }

        //删除超界
        int size = getListLength(head);
        if(position > size || position < 1) {
            System.out.println("输入参数有误");
            return head;
        }

        if(position == 1) {
            return head.next;
        } else {
            ListNode cur = head;
            int count = 1;
            while(count < position - 1) {
                cur = cur.next;
                count++;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
