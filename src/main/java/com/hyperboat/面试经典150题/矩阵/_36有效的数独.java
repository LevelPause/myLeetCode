package com.hyperboat.面试经典150题.矩阵;

public class _36有效的数独 {

  // 判断每一个条件并满足
  public boolean isValidSudoku2(char[][] board) {
    int[][] rows = new int[9][9];
    int[][] cols = new int[9][9];
    int[][][] miniBox = new int[3][3][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int curr = board[i][j];
        if (curr != '.') {
          int index = curr - '1';
          rows[i][index]++;
          cols[j][index]++;
          miniBox[i / 3][j / 3][index]++;
          if (rows[i][index] > 1 || cols[j][index] > 1 || miniBox[i / 3][j / 3][index] > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }

  // 优化空间，利用位运算减少一维空间
  public boolean isValidSudoku(char[][] board) {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[][] miniBox = new int[3][3];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        int curr = board[i][j];
        if (curr != '.') {
          int index = 1 << curr - '0';
          if ((rows[i] & index) == index || (cols[j] & index) == index
              || (miniBox[i / 3][j / 3] & index) == index) {
            return false;
          }
          rows[i] |= index;
          cols[j] |= index;
          miniBox[i / 3][j / 3] |= index;
        }
      }
    }
    return true;
  }
}
