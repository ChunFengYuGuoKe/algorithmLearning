package com.minmin.algorithmspass.charpter6_tree_level_travel.level2;

import com.minmin.algorithmspass.tools.TreeNode;

import java.util.*;

/**
 * LeetCode429
 * 给定一个 N 叉树，返回其节点值的层序遍历。
 * （即从左到右，逐层遍历）。
 */
public class NLevelOrder {
    public static void main(String[] args) {
        NTreeNode nTreeNode=NTreeNode.buildBinaryTree();
        System.out.println(nLevelOrder(nTreeNode));

    }



    public static List<List<Integer>> nLevelOrderByMyself(NTreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<NTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 这里之所以要新创建一个队列对象的原因是把之前的对象非空作为了判断条件
            // 如果在此期间还要在这上面加元素的话，就不能实现每一层一个集合了，而是所有节点都在一个集合中
            // 这也是queue = next这条语句在一个循环完成之后才执行的原因
            // 既是不想破坏循环终止条件的判定，也是为了获取下一轮需要遍历的队列
            // 既然如此，我是否可以不用这个辅助队列，像之前一样用size来标识终止条件，就像下面这样
            /*int size = queue.size();
            List<Integer> nd = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                NTreeNode cur = queue.remove();
                nd.add(cur.val);
                for (NTreeNode curChildren : cur.children) {
                    if (curChildren != null) {
                        queue.add(curChildren);
                    }
                }
            }
            res.add(nd);*/

            Deque<NTreeNode> next = new ArrayDeque<>();
            List<Integer> nd = new ArrayList<>();
            while (!queue.isEmpty()) {
                NTreeNode cur = queue.remove();
                nd.add(cur.val);
                for (NTreeNode curChildren : cur.children) {
                    if (curChildren != null) {
                        next.add(curChildren);
                    }
                }
            }
            queue = next;
            res.add(nd);
        }
        return res;
    }

    public static List<List<Integer>> nLevelOrder(NTreeNode root) {
        List<List<Integer>> value = new ArrayList<>();
        Deque<NTreeNode> q = new ArrayDeque<>();
        if (root != null)
            q.addLast(root);
        while (!q.isEmpty()) {
            Deque<NTreeNode> next = new ArrayDeque<>();
            List<Integer> nd = new ArrayList<>();
            while (!q.isEmpty()) {
                NTreeNode cur = q.pollFirst();
                nd.add(cur.val);
                for (NTreeNode chd : cur.children) {
                    if (chd != null)
                        next.add(chd);
                }
            }
            q = next;
            value.add(nd);
        }
        return value;
    }

}

class NTreeNode {
    public int val;
    public List<NTreeNode> children;


    public NTreeNode(int val, List<NTreeNode> children) {
        this.val = val;
        this.children = children;
    }


    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }


    public static NTreeNode buildBinaryTree() {
        List<NTreeNode> list11 = new ArrayList<>();
        List<NTreeNode> list12 = new ArrayList<>();
        List<NTreeNode> list13 = new ArrayList<>();
        List<NTreeNode> list14 = new ArrayList<>();

        List<NTreeNode> list3 = new ArrayList<>();
        list3.add(new NTreeNode(5, list11));
        list3.add(new NTreeNode(6, list12));
        NTreeNode nTreeNode3 = new NTreeNode(3, list3);

        List<NTreeNode> list1 = new ArrayList<>();
        list1.add(nTreeNode3);
        list1.add(new NTreeNode(2, list13));
        list1.add(new NTreeNode(4, list14));

        NTreeNode nTreeNode = new NTreeNode(1, list1);
        return nTreeNode;

    }

}
