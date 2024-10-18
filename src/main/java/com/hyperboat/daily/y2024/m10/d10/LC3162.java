package com.hyperboat.daily.y2024.m10.d10;

import java.util.HashMap;
import java.util.Map;
/*
* https://leetcode.cn/problems/find-the-number-of-good-pairs-i/description/
* */
public class LC3162 {

  class Solution {

    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
      int max = 0;
      for (int x : nums1) {
        max = Math.max(x, max);
      }
      int[] dp = new int[max / k + 1];
      for (int x : nums1) {
        if (x % k == 0) {
          dp[x / k]++;
        }
      }
      int ans = 0;
      Map<Integer, Integer> cnt = new HashMap<>();
      for (int y : nums2) {
        if (cnt.containsKey(y)) {
          ans += cnt.get(y);
        } else {
          int occ = 0;
          for (int i = y; i <= max / k; i += y) {
            occ += dp[i];
          }
          ans += occ;
          cnt.put(y, occ);
        }
      }
      return ans;
    }
  }
}
