package com.minmin.algorithmspass.charpter6_tree_level_travel.level2;

import com.minmin.algorithmspass.tools.BinaryTree;
import com.minmin.algorithmspass.tools.TreeNode;

import java.util.*;

/**
 * LeetCode103 题，
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）
 */
public class ZigzagLevelOrder {
    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = bTree.buildBinaryTree();
        List<List<Integer>> level = zigzagLevelOrder(bTree.root);
        System.out.println(level.toString());
    }
    enum Direction {
        LEFT2RIGHT,
        RIGHT2LEFT;
    }
    public static List<List<Integer>> zigzagLevelOrderByMyself(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Direction direction = Direction.LEFT2RIGHT;
        while (!queue.isEmpty()) {
            // true
            int size = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.remove();
                // 这里很巧妙，队列只是一个中间结果，我们不在意它是怎么一个顺序入队的
                // 只在意最后的集合中节点的值是怎么排布的
                /**
                 * 怎么控制一个元素的呈现顺序，如果是要先进先出，那么所有的节点一次插到末尾即可
                 * 如果是要后进先出，就每次新元素插到头部即可，这是栈的本质，原本是从左到右遍历，将顺序反转，
                 * 就变成了从右到左
                 */

                if (direction == Direction.LEFT2RIGHT) {
                    levelList.add(t.val);
                } else {
                    levelList.add(0, t.val);
                }
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(levelList);
            if (direction == Direction.LEFT2RIGHT) {
                direction = Direction.RIGHT2LEFT;
            } else {
                direction = Direction.LEFT2RIGHT;
            }

        }
        return res;
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isOrderLeft = true;
        while (!queue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = queue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}

