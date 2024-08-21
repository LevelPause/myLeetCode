package com.hyperboat.hot100.二叉树;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.cn/problems/path-sum-iii/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _437_路径总和III {

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

  class Solution {

    Map<Long, Integer> map = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
      if (root == null) {
        return 0;
      }
      map.put(0L, 1);
      return dfs(root, 0L, targetSum);
    }

    public int dfs(TreeNode root, long sum, int targetSum) {
      sum += root.val;
      int ans = map.getOrDefault(sum - targetSum, 0);
      map.put(sum, map.getOrDefault(sum, 0) + 1);
      if (root.left != null) {
        ans += dfs(root.left, sum, targetSum);
      }
      if (root.right != null) {
        ans += dfs(root.right, sum, targetSum);
      }
      map.put(sum, map.get(sum) - 1);
      return ans;
    }
  }
}
