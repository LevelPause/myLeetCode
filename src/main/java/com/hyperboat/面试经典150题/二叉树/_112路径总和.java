package com.hyperboat.面试经典150题.二叉树;

/*
https://leetcode.cn/problems/path-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class _112路径总和 {

  public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return targetSum == 0;
    }
    if (root.right == null && root.left == null) {
      return targetSum - root.val == 0;
    }

    return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
        targetSum - root.val);
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
