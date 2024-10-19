package com.hyperboat.normal.medium;

public class LC889 {

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

    private int[] preorder;
    private int[] index;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
      int n = preorder.length;
      if (n < 1) {
        return null;
      }

      this.preorder = preorder;
      index = new int[n + 1];
      for (int i = 0; i < n; i++) {
        index[postorder[i]] = i;
      }
      return dfs(0, n, 0);
    }

    private TreeNode dfs(int preL, int preR, int postL) {
      if (preL > preR) {
        return null;
      }
      if (preL == preR - 1) {
        return new TreeNode(preorder[preL]);
      }
      int lSize = index[preorder[preL + 1]] - postL + 1;
      TreeNode l = dfs(preL + 1, preL + lSize + 1, postL);
      TreeNode r = dfs(preL + lSize + 1, preR, postL + lSize);
      return new TreeNode(preorder[preL], l, r);
    }
  }
}
