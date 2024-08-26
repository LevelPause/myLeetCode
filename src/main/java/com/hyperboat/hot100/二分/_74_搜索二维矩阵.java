package com.hyperboat.hot100.二分;

public class _74_搜索二维矩阵 {

  class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
      int m = matrix.length;
      int n = matrix[0].length;
      int l = 0;
      int r = m * n - 1;

      while (l < r) {
        int mid = (l + r) >> 1;
        int midI = mid / n;
        int midJ = mid % n;
        if (matrix[midI][midJ] == target) {
          return true;
        } else if (matrix[midI][midJ] < target) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }

      return false;
    }
  }
}
