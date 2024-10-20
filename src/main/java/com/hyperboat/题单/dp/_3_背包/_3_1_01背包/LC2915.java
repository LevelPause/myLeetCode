package com.hyperboat.题单.dp._3_背包._3_1_01背包;

import java.util.Arrays;
import java.util.List;

/**
 * 2915. 和为目标值的最长子序列的长度
 * <p>
 * https://leetcode.cn/problems/length-of-the-longest-subsequence-that-sums-to-target/
 */
class LC2915 {

  public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = 0;
    int min = 0;
    for (int x : nums) {
      min = Math.min(x + min, target);
      for (int i = min; i >= x; i--) {
        dp[i] = Math.max(dp[i], dp[i - x] + 1);
      }
    }
    return dp[target] <= 0 ? -1 : dp[target];
  }


}
