package com.hyperboat.hot100.二叉树;

public class _226_翻转二叉树 {

  class Solution {

    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }
      TreeNode l = invertTree(root.left);
      TreeNode r = invertTree(root.right);
      root.right = l;
      root.left = r;
      return root;
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
