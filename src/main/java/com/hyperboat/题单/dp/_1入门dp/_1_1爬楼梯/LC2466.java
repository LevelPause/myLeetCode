package com.hyperboat.题单.dp._1入门dp._1_1爬楼梯;

/**
 * 2466. 统计构造好字符串的方案数
 * <p>
 * https://leetcode.cn/problems/count-ways-to-build-good-strings/description/
 */
class LC2466 {

  public int countGoodStrings(int low, int high, int zero, int one) {
    int mod = (int) 1e9 + 7;
    int[] dp = new int[high + 1];
    dp[0] = 1;
    int ans = 0;
    for (int i = 1; i <= high; i++) {
      if (i >= zero) {
        dp[i] = (dp[i] + dp[i - zero]) % mod;
      }
      if (i >= one) {
        dp[i] = (dp[i] + dp[i - one]) % mod;
      }
      if (i >= low) {
        ans = (ans + dp[i]) % mod;
      }
    }
    return ans;
  }

}
