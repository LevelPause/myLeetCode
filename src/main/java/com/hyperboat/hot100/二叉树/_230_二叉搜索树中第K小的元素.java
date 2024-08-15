package com.hyperboat.hot100.二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class _230_二叉搜索树中第K小的元素 {

  class Solution {

    public int kthSmallest(TreeNode root, int k) {
      Deque<TreeNode> qu = new LinkedList<>();
      int count = 0;

      while (root != null || !qu.isEmpty()) {

        while (root != null) {
          qu.push(root);
          root = root.left;
        }

        root = qu.poll();
        if (++count == k) {
          return root.val;
        }
        root = root.right;
      }

      return -1;
    }
  }

  public class TreeNode {

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
