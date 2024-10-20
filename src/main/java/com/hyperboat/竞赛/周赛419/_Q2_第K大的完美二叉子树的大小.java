package com.hyperboat.竞赛.周赛419;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.cn/contest/weekly-contest-419/problems/k-th-largest-perfect-subtree-size-in-binary-tree/
 * */
class _Q2_第K大的完美二叉子树的大小 {

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

  class Solution {

    List<Integer> ans = new ArrayList<>();

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
      dfs(root);
      ans.sort((o1, o2) -> o2 - o1);
      if (ans.size() < k) {
        return -1;
      }
      return 1 << ans.get(k - 1) - 1;
    }

    private int dfs(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int l = dfs(root.left);
      int r = dfs(root.right);
      if (l < 0 || r < 0) {
        return -1;
      }
      if (l != r) {
        return -1;
      }
      ans.add(l + 1);
      return l + 1;
    }
  }
}
