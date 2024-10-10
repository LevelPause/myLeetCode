package com.hyperboat.daily.y2024.m10.d02;

/*
 * https://leetcode.cn/problems/minimum-speed-to-arrive-on-time/description/
 * */
public class _1870_准时到达的列车最小时速 {

  class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
      int n = dist.length;
      if (hour <= n - 1) {
        return -1;
      }

      int l = 1, r = (int)1e7;
      while (l < r) {
        int m = (l + r) >> 1;
        double cost = 0;
        for (int i = 0; i < n - 1; i++) {
          cost += (int)Math.ceil((double) dist[i] / m);
        }
        cost += (double) dist[n - 1] / m;
        if (cost <= hour) {
          r = m;
        } else {
          l = m + 1;
        }
      }
      return r;
    }
  }
}
