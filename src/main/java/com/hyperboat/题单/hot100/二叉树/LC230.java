package com.hyperboat.题单.hot100.二叉树;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 230. 二叉搜索树中第K小的元素
 * <p>
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 */
class LC230 {

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
