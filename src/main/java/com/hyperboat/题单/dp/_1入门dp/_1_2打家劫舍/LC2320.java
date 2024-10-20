package com.hyperboat.题单.dp._1入门dp._1_2打家劫舍;

/**
 * 2320. 统计放置房子的方式数
 * <p>
 * https://leetcode.cn/problems/count-number-of-ways-to-place-houses/
 */
class LC2320 {

  private static final int MOD = (int) 1e9 + 7, MAX = (int) 1e4 + 1;
  private static final int[] dp = new int[MAX];

  static {
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < MAX; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
    }
  }

  public int countHousePlacements(int n) {
    return (int) (((long) dp[n] * dp[n]) % MOD);
  }

}
