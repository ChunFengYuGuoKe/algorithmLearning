package com.minmin.algorithmspass.charpter7_tree_and_recurison.level3;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.*;

/**
 * 基于迭代实现前序遍历
 */
public class PostOrderTraversal {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
//        bTree.root = bTree.buildBinaryTree();

        System.out.println(postOrderTraversal(bTree.root));
    }

    /**
     * 反转法实现
     *
     * @param root
     * @return
     */
    public static List<Integer> postOrderTraversalByMyself(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.getVal());
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node = node.right;
        }
        // Collections工具类有一个反转集合的方法
        Collections.reverse(res);
        return res;
    }


















    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.right;
            }
            node = stack.pop();
            node = node.left;
        }
        Collections.reverse(res);
        return res;
    }
}
