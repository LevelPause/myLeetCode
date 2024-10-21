package com.hyperboat.题单.面试经典150题.二分查找;

/*
 * https://leetcode.cn/problems/search-a-2d-matrix/?envType=study-plan-v2&envId=top-interview-150
 * */
class LC74 {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[m].length;
    int low = 0;
    int high = m * n - 1;
    while (low < high) {
      int mid = (low + high) / 2;
      if (matrix[mid / n][mid % n] == target) {
        return true;
      } else if (matrix[mid / n][mid % n] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return false;
  }
}
