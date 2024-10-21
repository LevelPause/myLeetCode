package com.hyperboat.题单.面试经典150题.二叉树;

/*
 * https://leetcode.cn/problems/count-complete-tree-nodes/?envType=study-plan-v2&envId=top-interview-150
 */
class LC222 {


  public int countNodes(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int lH = ca_H(root.left);
    int rH = ca_H(root.right);
    if (lH == rH) {
      return countNodes(root.right) + (1 << lH);
    } else {
      return countNodes(root.left) + (1 << rH);
    }
  }

  //  计算树高
  public int ca_H(TreeNode node) {
    int h = 0;
    if (node == null) {
      return h;
    }
    while (node != null) {
      h++;
      node = node.left;
    }
    return h;
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
