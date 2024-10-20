package com.hyperboat.daily.y2024.m09.d23;

class LC1014 {

  class Solution {

    public int maxScoreSightseeingPair(int[] values) {
      int ans = Integer.MIN_VALUE;
      int max = values[0];
      for (int i = 1, valuesLength = values.length; i < valuesLength; i++) {
        int value = values[i];
        ans = Math.max(ans, max + value - i);
        max = Math.max(max, i + value);
      }
      return ans;
    }
  }
}
