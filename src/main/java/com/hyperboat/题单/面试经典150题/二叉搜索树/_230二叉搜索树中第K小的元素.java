package com.hyperboat.题单.面试经典150题.二叉搜索树;

import java.util.ArrayDeque;
import java.util.Deque;

/*
https://leetcode.cn/problems/kth-smallest-element-in-a-bst/?envType=study-plan-v2&envId=top-interview-150
 */
class _230二叉搜索树中第K小的元素 {

  int count = 0;
  Deque<TreeNode> stack = new ArrayDeque<>();

  public int kthSmallest(TreeNode root, int k) {
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.offerFirst(root);
        root = root.left;
      }
      root = stack.pollFirst();
      if (++count == k) {
        return root.val;
      }
      root = root.right;
    }
    return -1;
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