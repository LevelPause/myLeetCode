package com.hyperboat.题单.面试经典150题.图;

/*
 * https://leetcode.cn/problems/surrounded-regions/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC130 {

  public void solve(char[][] board) {
    int row = board.length;
    int col = board[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        boolean isEdge = i == 0 || j == 0 || i == row - 1 || j == col - 1;
        if (isEdge && board[i][j] == 'O') {
          dfs(i, j, board);
        }
      }
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
        if (board[i][j] == '#') {
          board[i][j] = 'O';
        }
      }
    }
  }

  public void dfs(int i, int j, char[][] board) {
    if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == 'X'
        || board[i][j] == '#') {
      return;
    }
    board[i][j] = '#';
    dfs(i - 1, j, board);
    dfs(i + 1, j, board);
    dfs(i, j - 1, board);
    dfs(i, j + 1, board);
  }
}
