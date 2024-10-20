package com.hyperboat.题单.hot100.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * <p>
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 */
class LC94 {


  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    dfs(ans, root);
    return ans;
  }

  public void dfs(List<Integer> ans, TreeNode node) {
    if (node == null) {
      return;
    }
    dfs(ans, node.left);
    ans.add(node.val);
    dfs(ans, node.right);
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
