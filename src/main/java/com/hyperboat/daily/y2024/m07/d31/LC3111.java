package com.hyperboat.daily.y2024.m07.d31;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.cn/problems/minimum-rectangles-to-cover-points/description/
 * */
class LC3111 {

  // 简简单单一个贪心
  public int minRectanglesToCoverPoints(int[][] points, int w) {
    int n = points.length;
    Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
    int rangeR = -1;
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int[] point = points[i];
      if (point[0] > rangeR) {
        ans++;
        rangeR = point[0] + w;
      }
    }
    return ans;
  }

}
