package com.hyperboat.daily.y2024.m09.d16;

public class LC1184 {

  class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
      int n = distance.length;
      int ans = 0;
      int sum = 0;
      int cnt = n;
      boolean foundDes = false;
      while (cnt-- > 0) {
        if (start == destination) {
          foundDes = true;
        }
        if (!foundDes) {
          ans += distance[start];
        }
        sum += distance[start];
        start = (start + 1) % n;
      }
      return Math.min(ans, sum - ans);
    }
  }
}
