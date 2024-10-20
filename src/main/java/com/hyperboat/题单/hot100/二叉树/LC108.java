package com.hyperboat.题单.hot100.二叉树;

/**
 * 108. 将有序数组转换为二叉搜索树
 * <p>
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/
 */
class LC108 {

  public TreeNode sortedArrayToBST(int[] nums) {
    return dfs(0, nums.length, nums);
  }

  public TreeNode dfs(int l, int r, int[] nums) {
    if (l > r) {
      return null;
    }
    int m = (l + r) >> 1;
    TreeNode root = new TreeNode(nums[m]);
    TreeNode left = dfs(l, m - 1, nums);
    TreeNode right = dfs(m + 1, r, nums);
    root.left = left;
    root.right = right;
    return root;
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
