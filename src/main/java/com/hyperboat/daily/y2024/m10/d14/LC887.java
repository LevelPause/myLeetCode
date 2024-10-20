package com.hyperboat.daily.y2024.m10.d14;

/*
 * https://leetcode.cn/problems/super-egg-drop/description/
 * */
class LC887 {

  //谷歌经典面试题
  class Solution {

    private int[][] memo;

    public int superEggDrop(int k, int n) {
      int t = 1;
      memo = new int[k + 1][n + 1];
      while (calc(k, t) < n + 1) {
        t++;
      }
      return t;
    }

    private int calc(int k, int t) {
      if (memo[k][t] != 0) {
        return memo[k][t];
      }
      if (k == 1 || t == 1) {
        return t + 1;
      }
      return memo[k][t] = calc(k - 1, t - 1) + calc(k, t - 1);
    }
  }
}
