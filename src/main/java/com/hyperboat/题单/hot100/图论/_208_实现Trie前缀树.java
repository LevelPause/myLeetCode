package com.hyperboat.题单.hot100.图论;

public class _208_实现Trie前缀树 {

  class Trie {

    Trie[] children;
    boolean isLeaf;

    public Trie() {
      children = new Trie[26];
    }

    public void insert(String word) {
      Trie curr = this;
      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new Trie();
        }
        curr = curr.children[c - 'a'];
      }
      curr.isLeaf = true;
    }

    public boolean search(String word) {
      Trie curr = this;
      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          return false;
        }
        curr = curr.children[c - 'a'];
      }
      return curr.isLeaf;
    }

    public boolean startsWith(String prefix) {
      Trie curr = this;
      for (char c : prefix.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          return false;
        }
        curr = curr.children[c - 'a'];
      }
      return true;
    }
  }
}
