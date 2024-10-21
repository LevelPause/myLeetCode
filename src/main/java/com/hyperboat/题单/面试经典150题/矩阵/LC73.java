package com.hyperboat.题单.面试经典150题.矩阵;

class LC73 {

  public void setZeroes(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean[] row = new boolean[m];
    boolean[] col = new boolean[n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
        }
      }
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (row[i] || col[j]) {
          matrix[i][j] = 0;
        }
      }
    }
  }

  // 优化空间复杂度从O(m+n)->O(1),  策略为将原来所用来标记的空间放在第一行列
//  先将第一行列是否包含0用两个变量存起来
//  遍历剩余矩阵，将行列是否包含0的结果放入第一行列
//  遍历剩余矩阵，根据第一行列的标记更新矩阵
//  根据最初的变量标记更新第一行列
  public void setZeroes1(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean row = false;
    boolean col = false;
    for (int i = 0; i < n; i++) {
      if (matrix[0][i] == 0) {
        row = true;
        break;
      }
    }
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] == 0) {
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
      for (int i = 0; i < n; i++) {
        matrix[0][i] = 0;
      }
    }
    if (col) {
      for (int i = 0; i < m; i++) {
        matrix[i][0] = 0;
      }
    }
  }

}
