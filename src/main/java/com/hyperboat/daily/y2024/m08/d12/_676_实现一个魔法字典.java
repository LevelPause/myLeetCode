package com.hyperboat.daily.y2024.m08.d12;

/*
 * https://leetcode.cn/problems/implement-magic-dictionary/description/
 * */
public class _676_实现一个魔法字典 {

  Trie root;

  public _676_实现一个魔法字典() {
    root = new Trie();
  }

  public void buildDict(String[] dictionary) {
    root.insert(dictionary);
  }

  public boolean search(String searchWord) {
    return dfs(searchWord, root, 0, 1);
  }

  public boolean dfs(String word, Trie node, int index, int limit) {
    if (index == word.length()) {
      return node.isLeaf && limit == 0;
    }
    int idx = word.charAt(index) - 'a';
    if (node.children[idx] != null && dfs(word, node.children[idx], index + 1, limit)) {
      return true;
    }
    if (limit > 0) {
      for (int i = 0; i < 26; i++) {
        Trie child = node.children[i];
        if (i != idx && child != null && dfs(word, child, index + 1, limit - 1)) {
          return true;
        }
      }
    }
    return false;
  }

  class Trie {

    boolean isLeaf;
    Trie[] children;

    public Trie() {
      children = new Trie[26];
    }

    public void insert(String[] words) {
      for (String word : words) {
        Trie root = this;
        for (char c : word.toCharArray()) {
          if (root.children[c - 'a'] == null) {
            root.children[c - 'a'] = new Trie();
          }
          root = root.children[c - 'a'];
        }
        root.isLeaf = true;
      }
    }
  }
}
