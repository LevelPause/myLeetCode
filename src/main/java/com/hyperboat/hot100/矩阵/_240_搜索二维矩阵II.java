package com.hyperboat.hot100.矩阵;

/*
 * https://leetcode.cn/problems/search-a-2d-matrix-ii/?envType=study-plan-v2&envId=top-100-liked
 * */
public class _240_搜索二维矩阵II {

  public boolean searchMatrix(int[][] matrix, int target) {
    return bst(matrix, target);
  }

  public boolean bst(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    int l = n - 1;
    int r = 0;
    while (l >= 0 && r < m) {
      if (target < matrix[r][l]) {
        l--;
      } else if (target > matrix[l][r]) {
        r++;
      } else {
        return true;
      }
    }
    return false;
  }

  public boolean normal(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = m - 1; i >= 0; i--) {
      if (target >= matrix[i][0]) {
        for (int j = 0; j < n; j++) {
          if (target == matrix[i][j]) {
            return true;
          } else if (target < matrix[i][j]) {
            break;
          }
        }
      }
    }
    return false;
  }
}
