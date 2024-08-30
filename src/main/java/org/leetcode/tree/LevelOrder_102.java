package org.leetcode.tree;

import com.minmin.algorithmspass.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelVal = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curNode = queue.poll();
                assert curNode != null;
                levelVal.add(curNode.val);
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
            }
            result.add(levelVal);
        }

        return result;
    }
}
