package com.hyperboat.题单.位运算.其他;

/**
 * https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/description/
 */
class _1261_在受污染的二叉树中查找元素 {

  class FindElements {

    private TreeNode root;

    public FindElements(TreeNode root) {
      this.root = root;
      root.val = 0;
    }

    public boolean find(int target) {
      target++;
      TreeNode curr = root;
      //从次高位下标开始遍历
      for (int i = 30 - Integer.numberOfLeadingZeros(target); i >= 0; i--) {
        var bit = target >> i & 1;
        curr = bit == 0 ? curr.left : curr.right;
        if (curr == null) {
          return false;
        }
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

}
