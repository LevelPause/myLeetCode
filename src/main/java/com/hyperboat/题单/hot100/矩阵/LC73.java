package com.hyperboat.题单.hot100.矩阵;

/**
 * 73. 矩阵置零
 * <p>
 * https://leetcode.cn/problems/set-matrix-zeroes/description/
 */
class LC73 {

  public void setZeroes(int[][] matrix) {
    inPlace(matrix);
  }

  public void inPlace(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean row = false;
    boolean col = false;

    for (int j = 0; j < n; j++) {
      if (matrix[0][j] == 0) {
        row = true;
        break;
      }
    }
    for (int[] ints : matrix) {
      if (ints[0] == 0) {
        col = true;
        break;
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (row) {
      for (int j = 0; j < n; j++) {
        matrix[0][j] = 0;
      }
    }
    if (col) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
  }

  public void normal(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[] rows = new int[m];
    int[] cols = new int[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          rows[i] = 0;
          cols[j] = 0;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (rows[i] == 0 || cols[j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
  }
}
