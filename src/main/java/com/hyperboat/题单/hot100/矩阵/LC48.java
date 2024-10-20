package com.hyperboat.题单.hot100.矩阵;

/**
 * 48. 旋转图像
 * <p>
 * https://leetcode.cn/problems/rotate-image/?envType=study-plan-v2&envId=top-100-liked
 */
class LC48 {

  public void rotate(int[][] matrix) {
    int n = matrix.length;
    /*先水平翻转*/
    for (int i = 0; i < n >> 1; i++) {
      for (int j = 0; j < n; j++) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[n - i - 1][j];
        matrix[n - i - 1][j] = t;
      }
    }
    /*再沿对角线翻转*/
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int t = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = t;
      }
    }
  }
}
