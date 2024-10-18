package com.hyperboat.daily.y2024.m10.d05;

/*
 * https://leetcode.cn/problems/minimum-time-to-complete-trips/description/
 * */
public class LC2187 {

  class Solution {

    public long minimumTime(int[] time, int totalTrips) {
      int min = Integer.MAX_VALUE;
      for (int x : time) {
        min = Math.min(x, min);
      }
      long l = 1;
      long r = (long) totalTrips * min;
      while (l < r) {
        long m = (l + r) >>> 1;
        if (check(m, time, totalTrips)) {
          r = m;
        } else {
          l = m + 1;
        }
      }
      return r;
    }

    private boolean check(long t, int[] time, int totalTrips) {
      long sum = 0L;
      for (int x : time) {
        sum += t / x;
      }
      return sum >= totalTrips;
    }
  }
}
