package com.hyperboat.题单.hot100.二叉树;

import java.util.HashMap;
import java.util.Map;

public class _105_从前序与中序遍历序列构造二叉树 {

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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
      int n = preorder.length;
      /* key==value; value = inIndex;
       * */
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < n; i++) {
        map.put(inorder[i], i);
      }
      return dfs(preorder, map, 0, n - 1, 0, n - 1);
    }

    public TreeNode dfs(int[] preorder, Map<Integer, Integer> map, int preL, int preR, int inL,
        int inR) {
      if (preL > preR) {
        return null;
      }
      int value = preorder[preL];
      if (preL == preR) {
        return new TreeNode(value);
      }
      int inorderRoot = map.get(value);
      int nodeCount = inorderRoot - inL;
      return new TreeNode(value,
          dfs(preorder, map, preL + 1, preL + nodeCount, inL, inorderRoot - 1),
          dfs(preorder, map, preL + nodeCount + 1, preR, inorderRoot + 1, inR));
    }
  }
}
