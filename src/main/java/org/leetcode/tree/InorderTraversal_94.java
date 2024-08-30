package org.leetcode.tree;

import com.minmin.algorithmspass.tools.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal_94 {
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        } else {
            inorder(root);
            return ans;
        }
    }

    public void inorder(TreeNode root) {
        // 第一版终止条件这样写的
        // if (root.left == null && root.right == null) {
        //     ans.add(root.val);
        // }

        if (root == null) {
            return;
        }
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }

    public List<Integer> preOrderTraversal(TreeNode root) {
        // 1. 声明结果集合
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        // 2. 声明保存返回调用的栈
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;

        // 3. 前序遍历
        while (!stack.isEmpty() || node != null) {
            // 4. 如果当前节点不为null，就沿着左边这条路径一直向下搜索
            while(node != null) {
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
