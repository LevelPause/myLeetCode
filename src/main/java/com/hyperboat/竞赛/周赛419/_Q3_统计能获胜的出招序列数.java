package com.hyperboat.竞赛.周赛419;

import java.util.Arrays;

/*
 * https://leetcode.cn/problems/count-the-number-of-winning-sequences/description/
 * */
public class _Q3_统计能获胜的出招序列数 {


  class Solution {

    private static final int MOD = (int) 1e9 + 7;
    private int[] arr;
    private int[][][] memo;
    private int n;

    public int countWinningSequences(String s) {
      n = s.length();
      arr = new int[n];
      memo = new int[n][n * 2][3];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n * 2; j++) {
          Arrays.fill(memo[i][j], -1);
        }
      }
      for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        switch (c) {
          case 'F':
            arr[i] = 0;
            break;
          case 'W':
            arr[i] = 1;
            break;
          case 'E':
            arr[i] = 2;
            break;
        }
      }
      return dfs(n - 1, 0, -1);
    }

    private int dfs(int i, int j, int pre) {
      // 必败 投降
      if (-j > i) {
        return 0;
      }
      // 递归结束
      if (i < 0) {
        return 1;
      }
      if (pre >= 0 && memo[i][j + n][pre] >= 0) {
        return memo[i][j + n][pre];
      }
      int res = 0;
      for (int k = 0; k <= 2; k++) {
        if (k == pre) {
          continue;
        }
        int score = (k - arr[i] + 3) % 3;
        if (score == 2) {
          score = -1;
        }
        res = (res + dfs(i - 1, score + j, k)) % MOD;
      }
      if (pre >= 0) {
        memo[i][j + n][pre] = res;
      }
      return res;
    }
  }

}
