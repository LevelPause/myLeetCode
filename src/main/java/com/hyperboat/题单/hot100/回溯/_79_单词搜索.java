package com.hyperboat.题单.hot100.回溯;

public class _79_单词搜索 {

  class Solution {

    private char[][] board;
    private boolean[][] visited;
    private String word;
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;

    public boolean exist(char[][] board, String word) {
      this.board = board;
      m = board.length;
      n = board[0].length;
      visited = new boolean[m][n];
      this.word = word;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          visited = new boolean[m][n];
          if (backTrace(i, j, 0)) {
            return true;
          }
        }
      }
      return false;
    }

    private boolean backTrace(int i, int j, int index) {
      if (index == word.length() - 1) {
        return board[i][j] == word.charAt(index);
      }
      if (board[i][j] == word.charAt(index)) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
          int x = i + dir[0];
          int y = j + dir[1];
          if (x < m && x >= 0 && y < n && y >= 0 && !visited[x][y]) {
            if (backTrace(x, y, index + 1)) {
              return true;
            }
          }
        }
        visited[i][j] = false;
      }
      return false;
    }

  }
}
