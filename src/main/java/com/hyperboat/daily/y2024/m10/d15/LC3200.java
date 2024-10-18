package com.hyperboat.daily.y2024.m10.d15;

/**
 * https://leetcode.cn/problems/maximum-height-of-a-triangle/description/
 */
public class LC3200 {

  class Solution {

    public int maxHeightOfTriangle(int red, int blue) {
      return O1(red, blue);
    }

    private int On(int red, int blue) {
      var cnt = new int[2];
      int i = 0;
      while (true) {
        cnt[i & 1] += i;
        if ((cnt[0] > red || cnt[1] > blue) && (cnt[1] > red || cnt[0] > blue)) {
          return i - 1;
        }
        i++;
      }
    }

    private int O1(int red, int blue) {
      return Math.max(solve(red, blue), solve(blue, red));
    }

    private int solve(int m, int n) {
      var odd = (int) Math.sqrt(n);
      var even = (int) ((Math.sqrt(m * 4 + 1) - 1) / 2);
      return odd > even ? even * 2 + 1 : odd * 2;
    }
  }
}
