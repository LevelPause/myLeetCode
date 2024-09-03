package com.hyperboat.题单.面试经典150题.二叉树;

/*
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-interview-150
 * Definition for a binary tree node.
 * public class TreeNode {
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
public class _104二叉树的最大深度 {

  public int maxDepth(TreeNode root) {
    return dfs(0, root);
  }

  public int dfs(int n, TreeNode root) {
    if (root == null) {
      return n;
    }
    n++;
    int res1 = dfs(n, root.left);
    int res2 = dfs(n, root.right);
    return Math.max(res1, res2);
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
