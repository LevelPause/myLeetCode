package com.hyperboat.题单.面试经典150题.二叉树层次遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-interview-150
 */
class _102二叉树的层序遍历 {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> levelOrder(TreeNode root) {
    dfs(root, 0);
    return res;
  }

  public void dfs(TreeNode root, int deep) {
    if (root == null) {
      return;
    }
    if (deep == res.size()) {
      List<Integer> line = new ArrayList<>();
      line.add(root.val);
      res.add(line);
    } else {
      res.get(deep).add(root.val);
    }
    dfs(root.left, deep + 1);
    dfs(root.right, deep + 1);
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
