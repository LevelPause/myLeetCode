package com.hyperboat.daily.y2024.m09.d01;

public class LC1450 {

  class Solution {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
      int n = startTime.length;
      int ans = 0;

      for (int i = 0; i < n; i++) {
        if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
          ans++;
        }
      }

      return ans;
    }
  }
}
