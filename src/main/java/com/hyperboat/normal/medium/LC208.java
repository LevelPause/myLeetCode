package com.hyperboat.normal.medium;

/**
 * @author hyperboat
 * @date 2022年03月17日 3:28
 */
public class LC208 {

  Node root;

  public LC208() {
    root = new Node();
  }

  public void insert(String word) {
    root.insert(word);
  }

  public boolean search(String word) {
    return root.search(word);
  }

  public boolean startsWith(String prefix) {
    return root.startsWith(prefix);
  }

  static class Node {

    Node[] next;
    boolean isLeaf;

    public Node() {
      next = new Node[26];
    }

    public void insert(String word) {
      Node item = this;
      for (char ch : word.toCharArray()) {
        int idx = ch - 'a';
        if (item.next[idx] == null) {
          item.next[idx] = new Node();
        }
        item = item.next[idx];
      }
      item.isLeaf = true;
    }

    public boolean search(String word) {
      Node item = this;
      for (char ch : word.toCharArray()) {
        int idx = ch - 'a';
        if (item.next[idx] == null) {
          return false;
        }
        item = item.next[idx];
      }
      return item.isLeaf;
    }

    public boolean startsWith(String prefix) {
      Node item = this;
      for (char ch : prefix.toCharArray()) {
        int idx = ch - 'a';
        if (item.next[idx] == null) {
          return false;
        }
        item = item.next[idx];
      }
      return true;
    }
  }
}