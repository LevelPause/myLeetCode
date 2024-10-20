package com.hyperboat.题单.面试经典150题.二叉树;

/*
https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/?envType=study-plan-v2&envId=top-interview-150
*/

import java.util.ArrayList;
import java.util.List;

class _117填充每个节点的下一个右侧节点指针II {

  List<Node> nodes;

  public Node connect(Node root) {
    nodes = new ArrayList<>();
    if (root != null) {
      nodes.add(root);
    }
    dfs(nodes);
    return root;
  }

  public void dfs(List<Node> nodes) {
    if (nodes.isEmpty()) {
      return;
    }
    if (nodes.size() > 1) {
      for (int i = 0; i < nodes.size() - 1; i++) {
        nodes.get(i).next = nodes.get(i + 1);
      }
    }
    List<Node> subNodes = new ArrayList<>();
    for (Node node : nodes) {
      if (node.left != null) {
        subNodes.add(node.left);
      }
      if (node.right != null) {
        subNodes.add(node.right);
      }
    }
    dfs(subNodes);
  }

  class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}
