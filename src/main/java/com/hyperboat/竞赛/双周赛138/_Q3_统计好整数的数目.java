package com.hyperboat.竞赛.双周赛138;

public class _Q3_统计好整数的数目 {

  class Solution {

    long ans = 0;

    public long countGoodIntegers(int n, int k) {
      int[] pow10 = new int[n];
      pow10[0] = 1;
      for (int i = 1; i < n; i++) {
        pow10[i] = pow10[i - 1] * 10 % k;
      }

      int m = (n + 1) / 2;
      boolean[][] vis = new boolean[m + 1][k];
      dfs(0, 0, n, k, m, pow10, vis);
      return ans;
    }

    private void dfs(int i, int j, int n, int k, int m, int[] pow10, boolean[][] vis) {
      if (i == m) {
        ans++;
        return;
      }
      vis[i][j] = true;
      for (int d = 9; d >= 0; d--) { // 贪心：从大到小枚举
        int j2;
        if (n % 2 > 0 && i == m - 1) { // 正中间
          j2 = (j + d * pow10[i]) % k;
        } else {
          j2 = (j + d * (pow10[i] + pow10[n - 1 - i])) % k;
        }
        if (!vis[i + 1][j2]) {
          dfs(i + 1, j2, n, k, m, pow10, vis);
        }
      }
    }
  }

}
