package com.minmin.algorithmspass.charpter8_tree_hot_problems.level1.topic_双指针;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode104 对称问题
 */
public class Symmetry {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();

        bTree.root = bTree.buildBinaryTree3();
//        bTree.root = bTree.buildBinaryTreeComplex();

        boolean result;
        //LeetCode101 对称二叉树
        result = isSymmetric(bTree.root);
        System.out.println(result);
    }

    public boolean isSymmetricByMyself(TreeNode root) {
        /**
         * 方法1
         */
        // if (root == null) return true;
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.add(root);
        // while (!queue.isEmpty()) {
        //     int size = queue.size();

        //     // 用数组保存每一层遍历得到的数据
        //     int[] levelVal = new int[size];
        //     for (int i = 0; i < size; i++) {
        //         TreeNode node = queue.remove();
        //         levelVal[i] = node.val;
        //         if (node.left != null) {
        //             queue.add(node.left);
        //         }
        //         if (node.right != null) {
        //             queue.add(node.right);
        //         }
        //     }

        //     int left = 0, right = size - 1;
        //     while (left < right) {
        //         if (levelVal[left] != levelVal[right]) return false;
        //         left++;
        //         right--;
        //     }
        // }
        // return true;


        /**
         * 方法2
         * 很棒耶，已经能灵活运用之前学到的迭代遍历树的方法解出相关题目了，
         * 在第一种方法出bug之后也能迅速定位问题，尝试新的解法
         */
        if (root == null) return true;
        Deque<TreeNode> leftStack = new LinkedList<>();
        TreeNode leftNode = root;
        Deque<TreeNode> rightStack = new LinkedList<>();
        TreeNode rightNode = root;
        // 当左栈和右栈均非空或左节点和右节点均不为空时，继续遍历判断
        while ((!leftStack.isEmpty() && !rightStack.isEmpty()) || (leftNode != null && rightNode != null)) {
            while (leftNode != null && rightNode != null) {
                if (leftNode.val != rightNode.val) return false;
                leftStack.push(leftNode);
                leftNode = leftNode.left;
                rightStack.push(rightNode);
                rightNode = rightNode.right;
            }
            if (leftNode != null || rightNode != null) return false;
            leftNode = leftStack.pop();
            rightNode = rightStack.pop();
            // 如果两个节点在根节点相遇了，说明分别已经遍历完了自己那一边，就不用再往下进行了
            if (leftNode == rightNode) break;

            leftNode = leftNode.right;
            rightNode = rightNode.left;
        }
        return true;
    }

    /**
     * LeetCode101 对称二叉树
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    // 为什么需要双指针，因为需要同时获取两个节点的信息
    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }

}
