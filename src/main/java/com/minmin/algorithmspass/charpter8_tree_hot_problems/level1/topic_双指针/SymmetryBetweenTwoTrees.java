package com.minmin.algorithmspass.charpter8_tree_hot_problems.level1.topic_双指针;

import com.minmin.algorithmspass.tools.TreeNode;

/**
 * 判断两棵树是否对称
 */
public class SymmetryBetweenTwoTrees {
    public static boolean isSymmetryBetweenTwoTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return isSymmetryBetweenTwoTrees(t1.left, t2.right) && isSymmetryBetweenTwoTrees(t2.right, t2.left);
    }
}
