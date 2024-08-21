package com.hyperboat.hot100.二叉树;

/*
 * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _236_二叉树的最近公共祖先 {

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || p == root || q == root) {
        return root;
      }
      TreeNode l = lowestCommonAncestor(root.left, p, q);
      TreeNode r = lowestCommonAncestor(root.right, p, q);
      if (l != null && r != null) {
        return root;
      }
      return l != null ? l : r;
    }
  }
}
