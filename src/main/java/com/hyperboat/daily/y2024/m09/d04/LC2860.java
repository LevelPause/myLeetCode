package com.hyperboat.daily.y2024.m09.d04;

import java.util.Comparator;
import java.util.List;

public class LC2860 {

  class Solution {


    public int countWays(List<Integer> nums) {
      nums.sort(Comparator.comparingInt(o -> o));
      int ans = nums.get(0) == 0 ? 1 : 0;
      for (int i = 1; i < nums.size(); i++) {
        if (nums.get(i - 1) < i && i < nums.get(i)) {
          ans++;
        }
      }
      return ans;
    }
  }
}
