package com.hyperboat.题单.面试经典150题.分治;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-interview-150
 */
class _108将有序数组转换为二叉搜索树 {

  int[] nums;

  public TreeNode sortedArrayToBST(int[] nums) {
    int n = nums.length;
    this.nums = nums;
    return buildTree(0, n);
  }

  public TreeNode buildTree(int start, int end) {
    if (start > end) {
      return null;
    }
    int mid = (start + end) / 2;
    TreeNode curr = new TreeNode(nums[(start + end) / 2]);
    curr.left = buildTree(start, mid - 1);
    curr.right = buildTree(start, mid + 1);
    return curr;
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
//  0 1 2 3 4 5 6 7 8

