package com.hyperboat.hot100.二叉树;

public class _114_二叉树展开为链表 {

  class Solution {

    TreeNode pre;

    public void flatten(TreeNode root) {
      if (root == null) {
        return;
      }
      flatten(root.right);
      flatten(root.left);
      root.left = null;
      root.right = pre;
      pre = root;
    }
  }

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
}
