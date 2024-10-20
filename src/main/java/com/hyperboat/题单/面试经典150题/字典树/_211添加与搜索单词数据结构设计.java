package com.hyperboat.题单.面试经典150题.字典树;

/*
 * https://leetcode.cn/problems/design-add-and-search-words-data-structure/?envType=study-plan-v2&envId=top-interview-150
 * */
class _211添加与搜索单词数据结构设计 {

  Node root;

  public _211添加与搜索单词数据结构设计() {
    root = new Node();
  }

  public void addWord(String word) {
    root.addWord(word);
  }

  public boolean search(String word) {
    return dfs(0, root, word);
  }

  public boolean dfs(int index, Node root, String word) {
    if (word.length() == index) {
      return root.isLeaf;
    }
    char c = word.charAt(index);
    if (c == '.') {
      for (Node child : root.children) {
        if (child != null && dfs(index + 1, child, word)) {
          return true;
        }
      }
    } else {
      return root.children[c - 'a'] != null && dfs(index + 1, root.children[c - 'a'], word);
    }
    return false;
  }

  class Node {

    boolean isLeaf;
    Node[] children;

    public Node() {
      children = new Node[26];
    }

    public void addWord(String word) {

      for (char c : word.toCharArray()) {
        if (root.children[c - 'a'] == null) {
          root.children[c - 'a'] = new Node();
          root = root.children[c - 'a'];
        }
      }
      root.isLeaf = true;
    }
  }
}
