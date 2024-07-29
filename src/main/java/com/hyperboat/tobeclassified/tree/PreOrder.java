//package com.hyperboat.tree;
//
///**
// * @author hyperboat
// * @date 2022年03月10日 0:32
// */
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * 先序遍历
// */
//public class PreOrder {
//
//  @Test
//  public void test() {
//    Node node = new Node(3);
//    List<Node> nodes1 = new ArrayList<>();
//    Node node1 = new Node(32, new ArrayList<>());
//    nodes1.add(node1);
//    Node node2 = new Node(42, new ArrayList<>());
//    nodes1.add(node2);
//    node.children = nodes1;
//    List<Node> nodes2 = new ArrayList<>();
//    nodes1.add(new Node(2, new ArrayList<>()));
//    nodes1.add(new Node(2, new ArrayList<>()));
//    nodes1.add(new Node(2, new ArrayList<>()));
//    nodes1.add(new Node(2, nodes2));
//    node1.children = nodes2;
//    System.out.println(preorder(node));
//  }
//
//
//  public List<Integer> preorder(Node root) {
//    List<Integer> res = new ArrayList<>();
//    ca_ulateChild(root, res);
//    return res;
//  }
//
//  private void ca_ulateChild(Node node, List<Integer> res) {
//    if (node == null) {
//      return;
//    }
//    res.add(node.val);
//
//    for (Node child : node.children) {
//      ca_ulateChild(child, res);
//    }
//    res.add(null);
//  }
//
//  class Node {
//
//    public int val;
//    public List<Node> children;
//
//    public Node() {
//    }
//
//    public Node(int _val) {
//      val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//      val = _val;
//      children = _children;
//    }
//  }
//
//  ;
//}
