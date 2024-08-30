package org.leetcode.tree;


import com.minmin.algorithmspass.tools.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 思路1——采用层次遍历的思路，把每一层的元素保存在一个数组中，然后再用左右双指针进行遍历
// 思路2——也是采用双指针，只不过这次的双指针直接指向树的节点，一个迭代向左前序遍历，一个迭代向右前序遍历，这样就不会错过两个节点为空的信息
class IsSymmetric_101 {
    // public boolean isSymmetric(TreeNode root) {
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
    //     if (root == null) return true;
    //     Deque<TreeNode> leftStack = new LinkedList<>();
    //     TreeNode leftNode = root;
    //     Deque<TreeNode> rightStack = new LinkedList<>();
    //     TreeNode rightNode = root;
    //     // 当左栈和右栈均非空或左节点和右节点均不为空时，继续遍历判断
    //     while ((!leftStack.isEmpty() && !rightStack.isEmpty()) || (leftNode != null && rightNode != null)) {
    //         while (leftNode != null && rightNode != null) {
    //             if (leftNode.val != rightNode.val) return false;
    //             leftStack.push(leftNode);
    //             leftNode = leftNode.left;
    //             rightStack.push(rightNode);
    //             rightNode = rightNode.right;
    //         }
    //         if (leftNode != null || rightNode != null) return false;
    //         leftNode = leftStack.pop();
    //         rightNode = rightStack.pop();
    //         // 如果两个节点在根节点相遇了，说明分别已经遍历完了自己那一边，就不用再往下进行了
    //         if (leftNode == rightNode) break;

    //         leftNode = leftNode.right;
    //         rightNode = rightNode.left;
    //     }
    //     return true;
    // }

    // 失败的迭代法，因为我这里只用了一个node，而这道题与树的位置有关，所以需要两个节点分别沿着两条路走
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node = root;
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevelVals = new ArrayList<Integer>();

            for (int i = 0; i < size; i++) {
                node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                    curLevelVals.add(node.left.val);
                } else {
                    curLevelVals.add(null);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    curLevelVals.add(node.right.val);
                } else {
                    curLevelVals.add(null);
                }
            }

            for (int i = 0; i < size / 2; i++) {
                if (!curLevelVals.isEmpty() && !curLevelVals.get(i).equals(curLevelVals.get(size - 1 - i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            if (root.left.val != root.right.val) {
                return false;
            }
            return isSymmetric(root.left) && isSymmetric(root.right);
        }
    }

    // 方法y：递归
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    // 这里的递归不能只用一个参数，为什么，因为这里比较需要用到位置关系
    // 通过这条语句来实现check(l.left, r.right) && check(l.right, r.left);
    public boolean check(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (l == null || r == null) {
            return false;
        } else {
            return l.val == r.val && check(l.left, r.right) && check(l.right, r.left);
        }
    }

    // 方法x：迭代
    public boolean check1(TreeNode l, TreeNode r) {
        // 1. 定义队列
        Queue<TreeNode> queue = new LinkedList<>();

        // 2. 为队列添加初始值
        queue.add(l);
        queue.add(r);

        // 3. 循环层次判断是否为镜像
        while (!queue.isEmpty()) {
            // 3.1 从队列中取出两个值，用于判断
            TreeNode curL = queue.remove();
            TreeNode curR = queue.remove();

            // 3.2 条件判断是否为镜像
            // 这样涉及多个变量的复杂判断怎么能做？
            // 把每种情况列出来，分别判断
            if (curL == null && curR == null) {
                continue;
            } else if (curL == null || curR == null) {
                return false;
            } else if (curL.val != curR.val) {
                return false;
            } else {
                // 第一版，这里错了，既然已经用了两个辅助变量curL和curR，这里就应该用，用错了
                /**
                 * queue.add(l.left);
                 * queue.add(r.right);
                 *
                 * queue.add(l.right);
                 * queue.add(r.left);
                 */

                // 3.3 按照下一轮比较的顺序更新队列
                // 这就是队列的好处啊，后面加进来的值始终是排在前面元素的后面的
                // 队列出队的顺序是由入队的顺序决定的，所以想要操控出队顺序，就操控入队顺序就好了
                //
                queue.add(curL.left);
                queue.add(curR.right);

                queue.add(curL.right);
                queue.add(curR.left);
            }
        }
        return true;
    }
}