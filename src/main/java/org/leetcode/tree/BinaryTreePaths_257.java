package org.leetcode.tree;

import com.minmin.algorithmspass.tools.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class BinaryTreePaths_257 {
    static List<String> result = new ArrayList<>();
    public static List<String> binaryTreePaths(TreeNode root) {
        getAllPaths(new StringBuffer(), root);
        return result;
    }

    private static void getAllPaths(StringBuffer path, TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            String toAppend = Integer.toString(root.val);
            path.append(toAppend);
            result.add(path.toString());
            // 这里没考虑到 root.val 转化成的字符串可能不止一个字符，回溯得不干净
            // path.deleteCharAt(path.length() - 1);
            path.delete(path.length() - toAppend.length(), path.length());
            return;
        }
        if (root.left != null) {
            String toAppend = root.val + "->";
            path.append(toAppend);
            getAllPaths(path, root.left);
            path.delete(path.length() - toAppend.length(), path.length());
        }
        if (root.right != null) {
            String toAppend = root.val + "->";
            path.append(toAppend);
            getAllPaths(path, root.right);
            path.delete(path.length() - toAppend.length(), path.length());
        }                              
    }
}
