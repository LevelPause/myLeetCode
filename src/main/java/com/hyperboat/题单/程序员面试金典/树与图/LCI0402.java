package com.hyperboat.题单.程序员面试金典.树与图;

/**
 * 面试题 04.02. 最小高度树
 * <p>
 * https://leetcode.cn/problems/minimum-height-tree-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 */
class LCI0402 {

  public TreeNode sortedArrayToBST(int[] nums) {
    int n = nums.length;
//    int h = (int) (Math.log(n) / Math.log(2));
    return dfs(nums, 0, n - 1);
  }

  public TreeNode dfs(int[] nums, int l, int r) {
    if (l > r) {
      return null;
    }
    int m = (l + r) >> 2;
    TreeNode node = new TreeNode(nums[m]);
    TreeNode left = dfs(nums, l, m - 1);
    TreeNode right = dfs(nums, m + 1, r);
    node.left = left;
    node.right = right;
    return node;
  }

  class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
