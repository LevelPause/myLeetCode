package com.hyperboat.面试经典150题.二叉树;

/**
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class _124二叉树中的最大路径和 {

  int ans = Integer.MIN_VALUE;

  //将求直径的问题分解成求两条子链相加最长的问题
  public int maxPathSum(TreeNode root) {
    dfs(root);
    return ans;
  }

  public int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int lRes = dfs(root.left);
    int rRes = dfs(root.right);
//   左右子链相加，结果区最大值
    ans = Math.max(ans, lRes + rRes + root.val);
//    取最长子链和当前节点值相加，如果是负数就返回0， 相当于不要这条链
    return Math.max(Math.max(lRes, rRes) + root.val, 0);
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
