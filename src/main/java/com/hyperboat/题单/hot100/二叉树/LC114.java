package com.hyperboat.题单.hot100.二叉树;

/**
 * 114. 二叉树展开为链表
 * <p>
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 */
class LC114 {

  TreeNode pre;

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.right);
    flatten(root.left);
    root.left = null;
    root.right = pre;
    pre = root;
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
