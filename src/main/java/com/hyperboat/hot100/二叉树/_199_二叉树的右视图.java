package com.hyperboat.hot100.二叉树;

import java.util.ArrayList;
import java.util.List;

public class _199_二叉树的右视图 {

  class Solution {

    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
      res = new ArrayList<>();
      dfs(0, root);
      return res;
    }

    public void dfs(int deep, TreeNode root) {
      if (root == null) {
        return;
      }
      if (deep == res.size()) {
        res.add(root.val);
      }
      dfs(deep + 1, root.right);
      dfs(deep + 1, root.left);
    }
  }

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
}
