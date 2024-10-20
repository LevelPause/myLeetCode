package com.hyperboat.题单.hot100.二叉树;

/**
 * 226. 翻转二叉树
 * <p>
 * https://leetcode.cn/problems/invert-binary-tree/description/
 */
class LC226 {

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
