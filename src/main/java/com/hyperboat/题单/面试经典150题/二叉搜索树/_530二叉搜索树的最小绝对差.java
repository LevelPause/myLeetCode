package com.hyperboat.题单.面试经典150题.二叉搜索树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/?envType=study-plan-v2&envId=top-interview-150
 */
class _530二叉搜索树的最小绝对差 {

  int min = Integer.MAX_VALUE;
  List<Integer> nums = new ArrayList<>();

  public int getMinimumDifference(TreeNode root) {
    dfs(root);
    for (int i = 0; i < nums.size() - 1; i++) {
      min = Math.min(min, Math.abs(nums.get(i) - nums.get(i + 1)));
    }
    return min;
  }

  public void dfs(TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(node.left);
    nums.add(node.val);
    dfs(node.right);
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
