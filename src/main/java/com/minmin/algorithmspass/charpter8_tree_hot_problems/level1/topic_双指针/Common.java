package com.minmin.algorithmspass.charpter8_tree_hot_problems.level1.topic_双指针;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.*;

/**
 * LeetCode100 判断两棵树是否相同
 */
public class Common {
    public static void main(String[] args) {
        BinaryTree bTree1 = new BinaryTree();
        bTree1.root = bTree1.buildBinaryTree();

        BinaryTree bTree2 = new BinaryTree();
        bTree1.root = bTree2.buildBinaryTree();

        boolean result = isSameTreeBreadthFirst(bTree1.root, bTree2.root);

        System.out.println(result);
    }

    public static boolean isSameTreeByMyself(TreeNode p, TreeNode q) {

        // 这里大概需要画决策表来进行判断吧，其实一共就四种终止条件，先判断最先能判断的，排除掉这一种之后，再做定夺
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTreeByMyself(p.left, q.left) && isSameTreeByMyself(p.right, q.right);
    }

    public static boolean isSameTreeBreadthFirst(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        Queue<TreeNode> queue1 = new LinkedList<>();
        queue1.add(p);
        List<Integer> levelList1 = new ArrayList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue2.add(q);
        List<Integer> levelList2 = new ArrayList<>();
        while (!queue2.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.remove();
            levelList1.add(node1.getVal());
            if (node1.left != null) queue1.add(node1.left);
            if (node1.right != null) queue1.add(node1.right);
            TreeNode node2 = queue2.remove();
            levelList2.add(node2.getVal());
            if (node2.left != null) queue2.add(node2.left);
            if (node2.right != null) queue2.add(node2.right);
        }
        return levelList1.equals(levelList2);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        //如果都为空我们就认为他是相同的
        if (p == null && q == null)
            return true;
        //如果一个为空，一个不为空，很明显不可能是相同的树，直接返回false即可
        if (p == null || q == null)
            return false;
        //如果这两个节点都不为空并且又不相等，所以他也不可能是相同的树，直接返回false
        if (p.val != q.val)
            return false;
        //走到这一步说明节点p和q是完全相同的，我们只需要在比较他们的左右子节点即可
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
