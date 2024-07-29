package com.hyperboat.面试经典150题.字典树;

/*
 * https://leetcode.cn/problems/implement-trie-prefix-tree/description/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _208实现Trie前缀树 {

  Node root;

  public _208实现Trie前缀树() {
    this.root = new Node();
  }

  public void insert(String word) {
    Node curr = root;
    for (char c : word.toCharArray()) {
      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new Node();
      }
      curr = curr.children[c - 'a'];
    }
    curr.isLeaf = true;
  }

  public boolean search(String word) {
    Node curr = root;
    for (char c : word.toCharArray()) {
      Node child = curr.children[c - 'a'];
      if (child != null) {
        curr = child;
      } else {
        return false;
      }
    }
    return curr.isLeaf;
  }

  public boolean startsWith(String prefix) {
    Node curr = root;
    for (char c : prefix.toCharArray()) {
      Node child = curr.children[c - 'a'];
      if (child != null) {
        curr = child;
      } else {
        return false;
      }
    }
    return true;
  }

  class Node {

    boolean isLeaf;
    Node[] children = new Node[26];
  }
}

