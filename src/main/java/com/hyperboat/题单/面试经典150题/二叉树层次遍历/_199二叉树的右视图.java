package com.hyperboat.题单.面试经典150题.二叉树层次遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
public class _199二叉树的右视图 {

  List<Integer> res;

  public List<Integer> rightSideView(TreeNode root) {
    res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    dfs(root, 0);
    return res;
  }

  public void dfs(TreeNode node, int deep) {
    if (node == null) {
      return;
    }
    if (deep == res.size()) {
      res.add(node.val);
    }
    dfs(node.right, deep + 1);
    dfs(node.left, deep + 1);

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