package com.hyperboat.面试经典150题.区间;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=top-interview-150
 * */
public class _452用最少数量的箭引爆气球 {

  public int findMinArrowShots(int[][] points) {
    Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
    int pos = points[0][1];
    int ans = 1;
    for (int[] point : points) {
      //这个if判断代表没有交集, 就意味着需要一根新的弓箭
      if (point[0] > pos) {
        pos = point[1];
        ans++;
      }
    }
    return ans;
  }
}
