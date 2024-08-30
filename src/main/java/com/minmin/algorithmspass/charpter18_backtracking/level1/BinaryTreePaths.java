package com.minmin.algorithmspass.charpter18_backtracking.level1;



import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode257 二叉树的所有路径
 */
public class BinaryTreePaths {
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("第一行，XXX错误");
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<String> result = binaryTreePaths(bTree.root);
        System.out.println(result);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new ArrayList<>());
        return ans;
    }

    // 二叉树前序遍历、
    // 两个变量，一个ans保存结果集，一个temp保存每条路径的临时数据
    public static void dfsByMyself(TreeNode root, List<Integer> temp) {
        // 1. 终止条件，空节点返回
        if (root == null) {
            return;
        }
        // 2. 加入新节点
        temp.add(root.getVal());
        // 3. 判断如果是叶节点，就把这条路径加到结果集中
        if (root.left == null && root.right == null) {
            ans.add(getPathString(temp));
        }
        dfs(root.left, temp);
        dfs(root.right, temp);
        // 4. 回溯，回到处理当前子树之前的状态
        temp.remove(temp.size() - 1);
    }

    private static void dfs(TreeNode root, List<Integer> temp) {
        //空节点返回
        if (root == null) return;
        temp.add(root.val);
        //如果是叶子节点记录结果
        if (root.left == null && root.right == null) {
            ans.add(getPathString(temp));
        }
        dfs(root.left, temp);
        dfs(root.right, temp);
        temp.remove(temp.size() - 1);
    }

    //拼接结果
    private static String getPathString(List<Integer> temp) {
        StringBuilder sb = new StringBuilder();
        sb.append(temp.get(0));
        for (int i = 1; i < temp.size(); ++i) {
            sb.append("->").append(temp.get(i));
        }
        return sb.toString();
    }
}
