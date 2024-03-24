package com.minmin.algorithmspass.charpter7_tree_and_recurison.level3;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.*;

/**
 * 基于迭代实现前序遍历
 */
public class PreOrderTraversal {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
//        bTree.root = bTree.buildBinaryTree();

        System.out.println(preOrderTraversal(bTree.root));
    }



    public static List<Integer> preOrderTraversalByMyself(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        /**
         * 这里是用栈来保存了节点先后信息，保证了当前节点的前一个节点弹出后的下一个节点一定是父节点，
         * 这样就可以在左节点遍历完成之后能通过弹出的方式退回到父节点，从而访问右子树
         */
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.getVal());
                stack.push(node);
                node = node.left;
            }
            /**
             * 这里会一直向上弹，直到路径上一个节点的左子树不为空时进入前面的while循环，又开始同样的过程
             */
            node = stack.pop();
            node = node.right;
        }
        return res;
    }




    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

}
