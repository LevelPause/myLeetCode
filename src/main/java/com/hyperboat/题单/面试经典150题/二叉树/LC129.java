package com.hyperboat.题单.面试经典150题.二叉树;

/**
 * https://leetcode.cn/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150
 */
class LC129 {

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return dfs(root, 0);

  }

  public int dfs(TreeNode root, int sum) {
    if (root == null) {
      return 0;
    }
    sum = sum * 10 + root.val;
    if (root.right == root.left) {
      return sum;
    }
    int left = dfs(root.left, sum);
    int right = dfs(root.right, sum);
    return left + right;
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
