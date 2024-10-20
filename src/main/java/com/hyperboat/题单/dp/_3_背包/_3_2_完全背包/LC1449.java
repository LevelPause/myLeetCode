package com.hyperboat.题单.dp._3_背包._3_2_完全背包;

import java.util.Arrays;

/**
 * 1449.数位成本和为目标值的最大数字
 * <p>
 * https://leetcode.cn/problems/form-largest-integer-with-digits-that-add-up-to-target/description/
 */
class LC1449 {

  public String largestNumber(int[] cost, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, Integer.MIN_VALUE);
    dp[0] = 0;
    for (int x : cost) {
      for (int j = x; j <= target; j++) {
        dp[j] = Math.max(dp[j], dp[j - x] + 1);
      }
    }
    if (dp[target] < 0) {
      return "0";
    }
    StringBuilder ans = new StringBuilder();
    for (int i = 9; i > 0; i--) {
      int x = cost[i - 1];
      while (target >= x && dp[target] == dp[target - x] + 1) {
        ans.append(i);
        target -= x;
      }
    }
    return ans.toString();
  }

}
