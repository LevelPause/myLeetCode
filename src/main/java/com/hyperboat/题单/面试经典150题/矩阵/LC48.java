package com.hyperboat.题单.面试经典150题.矩阵;

class LC48 {

  public void rotate(int[][] matrix) {
    if (matrix.length <= 1) {
      return;
    }
    int edge = matrix.length;
    for (int i = 0; i < edge / 2; i++) {
      for (int j = 0; j < (edge + 1) / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[edge - 1 - j][i];
        matrix[edge - 1 - j][i] = matrix[edge - 1 - i][edge - 1 - j];
        matrix[edge - 1 - i][edge - 1 - j] = matrix[j][edge - 1 - i];
        matrix[j][edge - 1 - i] = temp;
      }
    }
  }
}
