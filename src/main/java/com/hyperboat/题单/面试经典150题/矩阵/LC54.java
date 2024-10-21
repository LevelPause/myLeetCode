package com.hyperboat.题单.面试经典150题.矩阵;

import java.util.ArrayList;
import java.util.List;

class LC54 {

  public List<Integer> spiralOrder(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int count = m * n;
    int index = 0;
    int rSide = n - 1;
    int lSide = 0;
    int tSide = 0;
    int bSide = m - 1;
    char curr = 'r';
    int i = 0, j = 0;
    List<Integer> ans = new ArrayList<>();
    while (index < count) {
      ans.add(matrix[i][j]);
      switch (curr) {
//        当前方向向右
        case 'r':
//          触碰右边界, 方向拐弯指向下, 右边界厚度-1
          if (j == rSide) {
            tSide++;
            curr = 'd';
            i++;
          } else {
            j++;
          }
          break;
        case 'l':
//          触碰左边界, 方向拐弯指向上, 左边界厚度-1
          if (j == lSide) {
            bSide--;
            curr = 'u';
            i--;
          } else {
            j--;
          }
          break;
        case 'u':
//          触碰上边界, 方向拐弯指向右, 上边界厚度-1
          if (i == tSide) {
            lSide++;
            curr = 'r';
            j++;
          } else {
            i--;
          }
          break;
        case 'd':
//           触碰下边界, 方向拐弯指向左, 下边界厚度-1
          if (i == bSide) {
            rSide--;
            curr = 'l';
            j--;
          } else {
            i++;
          }
          break;
      }
      index++;
    }
    return ans;
  }
}
