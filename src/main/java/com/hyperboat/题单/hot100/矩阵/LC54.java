package com.hyperboat.题单.hot100.矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * <p>
 * https://leetcode.cn/problems/spiral-matrix/description/
 */
class LC54 {

  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int u = 0;
    int d = m - 1;
    int l = 0;
    int r = n - 1;
    List<Integer> ans = new ArrayList<>();
    while (true) {
      /*从左到右*/
      for (int i = l; i <= r; i++) {
        ans.add(matrix[u][i]);
      }
      if (++u > d) {
        break;
      }
      /*从上到下*/
      for (int i = u; i <= d; i++) {
        ans.add(matrix[i][r]);
      }
      if (--r < l) {
        break;
      }
      /*从右到左*/
      for (int i = r; i >= l; i--) {
        ans.add(matrix[d][i]);
      }
      if (--d < u) {
        break;
      }
      /*从下到上*/
      for (int i = d; i >= u; i--) {
        ans.add(matrix[i][l]);
      }
      if (++u > r) {
        break;
      }
    }
    return ans;
  }
}
