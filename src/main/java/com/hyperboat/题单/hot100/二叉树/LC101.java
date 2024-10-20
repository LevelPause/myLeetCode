package com.hyperboat.题单.hot100.二叉树;

/**
 * 101. 对称二叉树
 * <p>
 * https://leetcode.cn/problems/symmetric-tree/description/
 */
class LC101 {


  public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root, root);
  }

  public boolean isSymmetric(TreeNode l, TreeNode r) {
    if (l == null || r == null) {
      return l == r;
    }
    return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
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
