package com.hyperboat.hot100.二叉树;

public class _543_二叉树的直径 {

  class Solution {

    int ans = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
      dfs(root);
      return ans;
    }

    public int dfs(TreeNode root) {
      if (root == null) {
        return -1;
      }
      int l = diameterOfBinaryTree(root.left) + 1;
      int r = diameterOfBinaryTree(root.right) + 1;
      ans = Math.max(ans, l + r);
      return Math.max(l, r);
    }
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
