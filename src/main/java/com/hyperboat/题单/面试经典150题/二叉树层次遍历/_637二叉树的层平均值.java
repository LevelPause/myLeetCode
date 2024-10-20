package com.hyperboat.题单.面试经典150题.二叉树层次遍历;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/average-of-levels-in-binary-tree/?envType=study-plan-v2&envId=top-interview-150
 */
class _637二叉树的层平均值 {

  List<Double> res = new ArrayList<>();
  List<Integer> counts = new ArrayList<>();

  public List<Double> averageOfLevels(TreeNode root) {
    dfs(root, 0);
    for (int i = 0; i < res.size(); i++) {
      res.set(i, res.get(i) / counts.get(i));
    }
    return res;
  }

  public void dfs(TreeNode node, int deep) {
    if (node == null) {
      return;
    }
    if (deep == res.size()) {
      res.add((double) node.val);
      this.counts.add(1);
    } else {
      res.set(deep, res.get(deep) + (double) node.val);
      this.counts.set(deep, counts.get(deep) + 1);
    }
    dfs(node.left, deep + 1);
    dfs(node.right, deep + 1);
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
