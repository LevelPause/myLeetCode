package com.hyperboat.题单.面试经典150题.二叉树;

/*
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-interview-150
 */
class _114二叉树展开为链表 {

  TreeNode preNode;

  // 反向前序遍历 右左中的顺序, 也就是从链表的最后一个开始改
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    flatten(root.right);
    flatten(root.left);
    root.left = null;
    root.right = preNode;
    preNode = root;
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
