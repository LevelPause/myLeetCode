package com.hyperboat.题单.dp._1入门dp._1_2打家劫舍;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3186_施咒的最大总伤害 {

  class Solution {

    public long maximumTotalDamage(int[] power) {
      Map<Integer, Long> map = new HashMap<>();
      for (int i : power) {
        map.merge(i, (long) i, Long::sum);
      }
      int[] ints = map.keySet().stream().mapToInt(o -> o).toArray();
      Arrays.sort(ints);
      return rob(ints, map);
    }

    private long rob(int[] nums, Map<Integer, Long> map) {
      int n = nums.length;
      long[] dp = new long[n + 1];
      int j = 0;
      for (int i = 0; i < n; i++) {
        while (nums[j] < nums[i] - 2) {
          j++;
        }
        dp[i + 1] = Math.max(dp[i], dp[j] + map.get(nums[i]));
      }
      return dp[n];
    }
  }
}
