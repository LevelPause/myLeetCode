package com.hyperboat.daily.y2024.m10.d13;

/*
 * https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/description/
 * */
class LC1884 {

  class Solution {

    public int twoEggDrop(int n) {
      return (int) Math.ceil((-1.0 + Math.sqrt(n * 8 + 1)) / 2);
    }

    private int twoEggDrop1(int n) {
      int t = 1;
      while (calc(2, t) < n + 1) {
        t++;
      }
      return t;
    }

    private int calc(int k, int t) {

      if (k == 1 || t == 1) {
        return t + 1;
      }
      return calc(k - 1, t - 1) + calc(k, t - 1);
    }
  }
}
