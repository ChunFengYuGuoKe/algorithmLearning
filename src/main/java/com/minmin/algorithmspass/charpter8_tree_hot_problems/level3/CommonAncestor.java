package com.minmin.algorithmspass.charpter8_tree_hot_problems.level3;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

/**
 * LeetCode 372 二叉树的最近公共祖先
 */
public class CommonAncestor {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = binaryTree.buildBinaryTree();

        TreeNode node = lowestCommonAncestor(binaryTree.root, binaryTree.root.right, binaryTree.root.left);
        System.out.println(node.val);

    }

    /**
     * 后序遍历的本质特征是什么，从表象上看，就是先递归调用处理左右子树，最后完成本结点的处理
     * @param root
     * @param p
     * @param q
     * @return
     */
    public static TreeNode lowestCommonAncestorByMyself(TreeNode root, TreeNode p, TreeNode q) {
        // 如果找到叶子节点还没找到，或者找到了需要找的节点，就终止递归，开始返回
        if (root == null || root == p || root == q) return root;
        // 在左右子树中搜索，搜到了left和right就为对应的节点
        TreeNode left = lowestCommonAncestorByMyself(root.left, p, q);
        TreeNode right = lowestCommonAncestorByMyself(root.right, p, q);
        if (left == null && right == null) return null;
        if (left == null) return right;
        if (right == null) return left;
        // 当搜到一个节点计算出的的left和right都不为null时，说明找到了最近祖先节点
        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null; // 1.
        if (left == null) return right; // 3.
        if (right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }


}
