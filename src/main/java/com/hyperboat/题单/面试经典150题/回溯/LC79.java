package com.hyperboat.题单.面试经典150题.回溯;

/*
 * https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC79 {

  boolean ans = false;
  Trie root = new Trie();
  boolean[][] visited;
  char[][] board;
  int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
  int n;
  int m;

  public boolean exist(char[][] board, String word) {
    root.insert(word);
    this.board = board;
    n = board.length;
    m = board[0].length;
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        backTrace("", i, j);
      }
    }
    return ans;
  }

  public void backTrace(String word, int i, int j) {
    if (ans || i < 0 || j < 0 || i > n - 1 || j > m - 1 || visited[i][j]) {
      return;
    }
    word += board[i][j];
    if (!root.startWith(word)) {
      return;
    }
    if (root.search(word)) {
      ans = true;
      return;
    }
    for (int[] dir : dirs) {
      visited[i][j] = true;
      backTrace(word, i + dir[0], j + dir[1]);
      visited[i][j] = false;
    }
  }

  class Trie {

    boolean isLeaf;
    Trie[] children;

    public Trie() {
      children = new Trie[60];
    }

    public void insert(String word) {
      Trie root = this;
      for (char c : word.toCharArray()) {
        if (root.children[c - 'A'] == null) {
          root.children[c - 'A'] = new Trie();
        }
        root = root.children[c - 'A'];
      }
      root.isLeaf = true;
    }

    public boolean search(String word) {
      Trie root = this;
      for (char c : word.toCharArray()) {
        if (root.children[c - 'A'] == null) {
          return false;
        }
        root = root.children[c - 'A'];
      }
      return root.isLeaf;
    }

    public boolean startWith(String word) {
      Trie root = this;
      for (char c : word.toCharArray()) {
        if (root.children[c - 'A'] == null) {
          return false;
        }
        root = root.children[c - 'A'];
      }
      return true;
    }

  }
}
