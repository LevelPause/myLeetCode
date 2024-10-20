package com.hyperboat.题单.面试经典150题.二叉树层次遍历;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
class _103二叉树的锯齿形层序遍历 {

  // bfs
  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    dfs(root, 0);
    for (int i = 0; i < res.size(); i++) {
      if (i % 2 > 0) {
        Collections.reverse(res.get(i));
      }
    }
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
