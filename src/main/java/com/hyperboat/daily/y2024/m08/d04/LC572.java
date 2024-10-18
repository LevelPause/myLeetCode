package com.hyperboat.daily.y2024.m08.d04;

/*
 * https://leetcode.cn/problems/subtree-of-another-tree/description/
 * */
public class LC572 {

  public boolean isSubtree(TreeNode root, TreeNode subRoot) {
    return check(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
  }

  public boolean check(TreeNode root, TreeNode subRoot) {
    if (subRoot == null) {
      return subRoot == root;
    }
    if (subRoot.val != root.val) {
      return false;
    }
    return check(root.left, subRoot.left) || check(root.right, subRoot.right);
  }

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
