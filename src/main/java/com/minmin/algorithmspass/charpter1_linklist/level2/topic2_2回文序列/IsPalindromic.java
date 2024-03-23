package com.minmin.algorithmspass.charpter1_linklist.level2.topic2_2回文序列;

import java.util.Stack;

/***
 * 判断链表是否回文
 */
public class IsPalindromic {
    static ListNode temp;

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1};
        ListNode node = initLinkedList(a);
        int testMethod = 1;
        boolean result = false;
        switch (testMethod) {
            case 1://方法1：通过双指针的方式来判断
                result = isPalindromeByReverseLinkedList(node);
                break;
            case 2: //方法2：全部压栈
                result = isPalindromeByAllStack(node);
                break;
            case 3://方法3：只将一半的数据压栈
                result = isPalindromeByHalfStack(node);
                break;
            case 4://方法4：通过递归来实现
                result = isPalindromeByRe(node);
                break;

        }
        System.out.println("result:" + result);
    }


    /**
     * 方法1：通过双指针的方式来判断
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = head;
        ListNode prepre = null;
        while(fast != null && fast.next != null) {
            //java中把一个对象赋值给另一个对象
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(slow.next != null) {
            //在这里遭遇了bug
            if(slow.val != pre.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }


    /**
     * 方法1：通过双指针的方式来判断
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByTwoPoints(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //pre和prepre是干什么吃的？这俩货是用来翻转链表的
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        //这个判定条件是为了让slow和pre在奇数的时候少走一步
        // && fast.next != null，这个条件有可能是为了防止超界用的
        while (fast != null && fast.next != null) {
            pre = slow;//这个赋值放在这里也是有讲究的，保证了slow和pre一前一后的关系，pre是落后slow一个身位的
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        //为啥这个fast != null还要单拎出来，直觉是跟奇偶有关
        if (fast != null) {
            slow = slow.next;
        }
        /*if (fast == null) {
            pre = pre.next;
        }*/
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    /**
     * 方法2：全部压栈
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByAllStack(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack();
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        //然后再出栈
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 方法3：只将一半的数据压栈
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeByHalfStack(ListNode head) {
        if (head == null)
            return true;
        ListNode temp = head;
        Stack<Integer> stack = new Stack();
        //链表的长度
        int len = 0;
        //把链表节点的值存放到栈中
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
            len++;
        }
        //len长度除以2，不用除以2是有好处的，可以避免取整的问题，这样相对于就是向下取整
        len >>= 1;
        //然后再出栈
        while (len-- >= 0) {
            if (head.val != stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }

    /**
     * 方法4：通过递归来实现
     */
    public static boolean isPalindromeByRe(ListNode head) {
        temp = head;
        return check(head);
    }

    private static boolean check(ListNode head) {
        if (head == null)
            return true;
        boolean res = check(head.next) && (temp.val == head.val);
        temp = temp.next;
        return res;
    }

    public static boolean isPalindromeByReverseLinkedList(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        ListNode cur = head;
        ListNode pre = new ListNode(cur.val);
        ListNode prepre = null;
        while(cur != null) {
            pre = new ListNode(cur.val);
//            pre = cur;
            cur = cur.next;
            pre.next = prepre;
            prepre = pre;
        }
        while(pre.next != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }


    /**
     * 用数组初始化链表
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

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
