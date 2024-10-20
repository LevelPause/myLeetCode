package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/**
 * 879. 盈利计划
 * <p>
 * https://leetcode.cn/problems/profitable-schemes/description/
 */
class LC879 {

  public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
    int mod = (int) 1e9 + 7;
    int len = profit.length;
    int[][] dp = new int[n + 1][minProfit + 1];

    for (int i = 0; i <= n; i++) {
      dp[i][0] = 1;
    }

    for (int i = 0; i < len; i++) {
      int a = group[i];
      int b = profit[i];
      for (int j = n; j >= a; j--) {
        for (int k = minProfit; k >= 0; k--) {
          int max = Math.max(k - b, 0);
          dp[j][k] = (dp[j][k] + dp[j - a][max]) % mod;
        }
      }
    }

    return dp[n][minProfit];
  }

}
