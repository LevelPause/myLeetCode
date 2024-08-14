package com.hyperboat.hot100.二叉树;

import java.util.ArrayList;
import java.util.List;

public class _102_二叉树的层序遍历 {

  class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
      res = new ArrayList<>();
      dfs(0, root);
      return res;
    }

    public void dfs(int deep, TreeNode root) {
      if (root == null) {
        return;
      }
      if (deep == res.size()) {
        List<Integer> line = new ArrayList<>();
        line.add(root.val);
        res.add(line);
      } else {
        res.get(deep).add(root.val);
      }
      dfs(deep + 1, root.left);
      dfs(deep + 1, root.right);
    }
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
