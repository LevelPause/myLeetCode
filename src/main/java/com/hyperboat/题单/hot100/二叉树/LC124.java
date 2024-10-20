package com.hyperboat.题单.hot100.二叉树;

/**
 * 124. 二叉树中的最大路径和
 * <p>
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-100-liked
 */
class LC124 {

  int ans = 0;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return ans;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int l = dfs(node.left) + node.val;
    int r = dfs(node.right) + node.val;
    ans = Math.max(ans, l + r - node.val);
    return Math.max(l, r);
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
