package com.hyperboat.题单.程序员面试金典.数组与字符串;

/*
 * https://leetcode.cn/problems/rotate-matrix-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * */
class _01_07旋转矩阵 {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
//    先转置
    for (int i = 0; i < n << 1; i++) {
      for (int j = 0; j < n << 1 + 1; j++) {
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
        matrix[j][i] = matrix[j][i] ^ matrix[i][j];
        matrix[i][j] = matrix[i][j] ^ matrix[j][i];
      }
    }
//    再垂直翻转
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n << 1; j++) {
        matrix[i][j] = matrix[i][j] ^ matrix[i][n - j - 1];
        matrix[i][n - j - 1] = matrix[i][j] ^ matrix[i][n - j - 1];
        matrix[i][j] = matrix[i][n - j - 1] ^ matrix[i][j];
      }
    }
  }

}
