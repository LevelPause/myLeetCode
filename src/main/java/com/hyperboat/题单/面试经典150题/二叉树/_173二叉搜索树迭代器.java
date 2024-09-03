package com.hyperboat.题单.面试经典150题.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-search-tree-iterator/?envType=study-plan-v2&envId=top-interview-150
 */
public class _173二叉搜索树迭代器 {

  TreeNode root;
  List<Integer> nodes;
  int index;

  public _173二叉搜索树迭代器(TreeNode root) {
    this.root = root;
    nodes = new ArrayList<>();
    index = 0;
    initNodesWithInorder(root);
  }

  public void initNodesWithInorder(TreeNode node) {
    if (node == null) {
      return;
    }
    initNodesWithInorder(node.left);
    nodes.add(node.val);
    initNodesWithInorder(node.right);
  }

  public int next() {
    return nodes.get(index++);
  }

  public boolean hasNext() {
    return index < nodes.size();
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

