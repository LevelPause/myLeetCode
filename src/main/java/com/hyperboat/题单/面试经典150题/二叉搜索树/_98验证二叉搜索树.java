package com.hyperboat.题单.面试经典150题.二叉搜索树;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/validate-binary-search-tree/?envType=study-plan-v2&envId=top-interview-150
 */
class _98验证二叉搜索树 {

  Deque<TreeNode> stack = new ArrayDeque<>();

  public boolean isValidBST(TreeNode root) {
    boolean first = true;
    int lastNum = 0;
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.offerFirst(root);
        root = root.left;
      }
      root = stack.pollFirst();
      if (first) {
        first = false;
      } else {
        if (lastNum > root.val) {
          return false;
        }
      }
      lastNum = root.val;
      root = root.right;
    }
    return true;
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
