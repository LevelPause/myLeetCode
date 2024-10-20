package com.hyperboat.题单.面试经典150题.字典树;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.cn/problems/word-search-ii/?envType=study-plan-v2&envId=top-interview-150
 * */
class _212单词搜索II {

  List<String> ans;
  Trie trie;
  int n;
  int m;

  public List<String> findWords(char[][] board, String[] words) {
    n = board.length;
    m = board[0].length;
    trie = new Trie(words);
    ans = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        dfs("", i, j, board);
      }
    }
    return ans;
  }

  public void dfs(String word, int i, int j, char[][] board) {
    if (i < 0 || j < 0 || i == n || j == m || board[i][j] == 'A') {
      return;
    }

    word += board[i][j];
    if (!trie.startsWith(word)) {
      return;
    }
    if (trie.search(word)) {
      if (!ans.contains(word)) {
        ans.add(word);
      }
    }
    char c = board[i][j];
    board[i][j] = 'A';
    dfs(word, i + 1, j, board);
    dfs(word, i - 1, j, board);
    dfs(word, i, j + 1, board);
    dfs(word, i, j - 1, board);
    board[i][j] = c;
  }

  class Trie {

    boolean isLeaf;
    Trie[] children;

    public Trie() {
      children = new Trie[26];
    }

    public Trie(String[] words) {
      children = new Trie[26];
      insert(words);
    }

    public void insert(String[] words) {
      for (String word : words) {
        Trie curr = this;
        for (char c : word.toCharArray()) {
          if (curr.children[c - 'a'] == null) {
            curr.children[c - 'a'] = new Trie();
          }
          curr = curr.children[c - 'a'];
        }
        curr.isLeaf = true;
      }
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

    public boolean startsWith(String word) {
      Trie curr = this;
      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          return false;
        }
        curr = curr.children[c - 'a'];
      }
      return true;
    }
  }
}
