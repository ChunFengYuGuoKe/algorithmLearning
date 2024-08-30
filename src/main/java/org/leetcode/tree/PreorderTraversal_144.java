package org.leetcode.tree;

import com.minmin.algorithmspass.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */

/**
 * 1. 栈的好处是能保留顺序信息
 */
public class PreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode curNode = st.pop();
            result.add(curNode.val);
            /**
             * 先压右节点，再压左节点，这样根据栈先进后出的特点，等会儿就会先弹出左节点，先对左节点进行处理
             * 符合中、左、右的顺序
             */
            if (curNode.right != null) st.push(curNode.right);
            if (curNode.left != null) st.push(curNode.left);
        }
        return result;
    }
}
