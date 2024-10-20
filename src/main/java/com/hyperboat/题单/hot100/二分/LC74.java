package com.hyperboat.题单.hot100.二分;

/**
 * 74. 搜索二维矩阵
 * <p>
 * https://leetcode.cn/problems/search-a-2d-matrix/description/
 */
class LC74 {

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
