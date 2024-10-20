package com.hyperboat.题单.hot100.二叉树;

/**
 * 104. 二叉树的最大深度
 * <p>
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 */
class LC104 {


  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
