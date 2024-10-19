package com.hyperboat.normal.medium;

public class LC99 {

  public class TreeNode {

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

  class Solution {

    TreeNode min = null;
    TreeNode max = null;
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
      dfs(root);
      swap(min, max);
    }

    private void dfs(TreeNode root) {
      if (root == null) {
        return;
      }
      dfs(root.left);
      if (root.val < pre.val) {
        min = root;
        if (max == null) {
          max = pre;
        }
      }
      pre = root;
      dfs(root.right);
    }

    private void swap(TreeNode x, TreeNode y) {
      int t = x.val;
      x.val = y.val;
      y.val = t;
    }
  }
}
