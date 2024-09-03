package com.hyperboat.题单.hot100.二叉树;

import java.util.Deque;
import java.util.LinkedList;

/*
 * https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _98_验证二叉搜索树 {

  class Solution {

    public boolean isValidBST(TreeNode root) {
      Deque<TreeNode> qu = new LinkedList<>();
      boolean first = true;
      int lastNum = 0;
      while (root != null || !qu.isEmpty()) {
        while (root != null) {
          qu.offer(root);
          root = root.left;
        }
        root = qu.pollFirst();
        if (first) {
          first = false;
        } else {
          if (lastNum >= root.val) {
            return false;
          }
        }
        lastNum = root.val;
        root = root.right;
      }
      return true;
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
