package com.hyperboat.daily.y2024.m08.d22;

/*
 * https://leetcode.cn/problems/minimum-array-end/
 * */
class LC3133 {

  class Solution {

    public long minEnd(int n, int x) {
      n--;
      long ans = x;
      int j = 0;
      for (long t = ~x, lb; (n >> j) > 0; t ^= lb) {
        lb = t & -t;
        ans |= (long) (n >> j++ & 1) * lb;
      }
      return ans;
    }
  }
}
