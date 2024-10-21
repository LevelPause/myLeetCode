package com.hyperboat.题单.面试经典150题.二叉树;

/*
 * https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&envId=top-interview-150
 * Definition for a binary tree node.
 * class TreeNode {
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
class LC101 {

  public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root, root);
  }

  public boolean isSymmetric(TreeNode p, TreeNode q) {
    if (p == null || q == null) {
      return p == q;
    }
    return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
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
