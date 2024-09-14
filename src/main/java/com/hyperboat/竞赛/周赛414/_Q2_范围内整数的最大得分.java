package com.hyperboat.竞赛.周赛414;

import java.util.Arrays;

public class _Q2_范围内整数的最大得分 {

  //todo 没完全掌握
// 二分, 在求最大化最小值或最小化最大值的时候就要想到用二分
  class Solution {

    public int maxPossibleScore(int[] start, int d) {
      Arrays.sort(start);
      int n = start.length;
      int left = 0;
      int right = (start[n - 1] + d - start[0]) / (n - 1) + 1;
      while (left + 1 < right) {
        int mid = (left + right) >>> 1;
        if (check(start, d, mid)) {
          left = mid;
        } else {
          right = mid;
        }
      }
      return left;
    }

    private boolean check(int[] start, int d, int score) {
      long x = Long.MIN_VALUE;
      for (int s : start) {
        x = Math.max(x + score, s); // x 必须 >= 区间左端点 s
        if (x > s + d) {
          return false;
        }
      }
      return true;
    }
  }
}
