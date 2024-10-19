package com.hyperboat.normal.medium;

/**
 * @author zhangweigang
 * @date 2023年10月24日
 */
public class LC1155 {

  //01背包问题
  //理解还不够深刻, 有空再多看看 todo
  public int numRollsToTarget(int n, int k, int target) {

    int mod = (int) 1e9 + 7;
    int[] dp = new int[target + 1];
    dp[0] = 1;
    // 枚举物品组（每个骰子）
    for (int i = 1; i <= n; i++) {
      // 枚举背包容量（所掷得的总点数）
      for (int j = target; j >= 0; j--) {
        dp[j] = 0;
        // 枚举决策（当前骰子所掷得的点数）
        for (int j1 = 1; j1 <= k; j1++) {
          if (j >= j1) {
            dp[j] = (dp[j] + dp[j - j1]) % mod;
          }
        }
      }
    }
    return dp[target];
  }
}
