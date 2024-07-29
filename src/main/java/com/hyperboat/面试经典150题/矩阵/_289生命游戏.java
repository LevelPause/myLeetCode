package com.hyperboat.面试经典150题.矩阵;

public class _289生命游戏 {

  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    final int TO_DIE = -1;
    final int REBORN = 2;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int count = 0;
//        上方
        if (i > 0 && (board[i - 1][j] == 1 || board[i - 1][j] == TO_DIE)) {
          count++;
        }
//        左方
        if (j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == TO_DIE)) {
          count++;
        }
//        左上
        if (i > 0 && j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == TO_DIE)) {
          count++;
        }
//        左下
        if (i < m - 1 && j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == TO_DIE)) {
          count++;
        }
//        右上
        if (i > 0 && j < n - 1 && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == TO_DIE)) {
          count++;
        }
//        右方
        if (j < n - 1 && (board[i][j + 1] == 1 || board[i][j + 1] == TO_DIE)) {
          count++;
        }
//        上方
        if (i < m - 1 && (board[i + 1][j] == 1 || board[i + 1][j] == TO_DIE)) {
          count++;
        }
//        右下
        if (i < m - 1 && j < n - 1 && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == TO_DIE)) {
          count++;
        }
        if (board[i][j] == 1) {
          if (count < 2 || count > 3) {
            board[i][j] = TO_DIE;
          }
        } else {
          if (count == 3) {
            board[i][j] = REBORN;
          }
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == TO_DIE) {
          board[i][j] = 0;
        }
        if (board[i][j] == REBORN) {
          board[i][j] = 1;
        }
      }
    }
  }
}
