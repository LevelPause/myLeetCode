package com.hyperboat.面试经典150题.图;

/*
https://leetcode.cn/problems/clone-graph/?envType=study-plan-v2&envId=top-interview-150
*/

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _133克隆图 {

  Map<Node, Node> source2Copy =new HashMap<>();
  Deque<Node> stack;

  public Node cloneGraph(Node node) {
/*
   BFS 主体
   if (node == null) {
      return null;
    }
    Node ans = new Node(node.val);
    source2Copy.put(node, ans);
    stack = new ArrayDeque();
    stack.offerFirst(node);
    bfs(stack);
    return ans;*/
    if (node == null) {
      return null;
    }
    if (source2Copy.containsKey(node)) {
      return source2Copy.get(node);
    }
    Node clone = new Node(node.val);
    source2Copy.put(node, clone);
    for (Node line : node.neighbors) {
      clone.neighbors.add(cloneGraph(line));
    }
    return clone;
  }

  public void bfs(Deque<Node> stack) {
    while (!stack.isEmpty()) {
      int size = stack.size();
      for (int i = 0; i < size; i++) {
        Node node = stack.pollFirst();
        Node copy = source2Copy.get(node);
        for (Node neighbor : node.neighbors) {
          Node copyNei;
          if (source2Copy.containsKey(neighbor)) {
            copyNei = source2Copy.get(neighbor);
          } else {
            copyNei = new Node(neighbor.val);
            source2Copy.put(neighbor, copyNei);
            stack.offerFirst(neighbor);
          }
          copy.neighbors.add(copyNei);
        }
      }
    }
  }


  class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }
}
