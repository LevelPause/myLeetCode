package com.hyperboat.竞赛.周赛411;

public class Q3_找出最大的N位K回文数 {

  class Solution {

    public String largestPalindrome(int n, int k) {
      int m = (n + 1) / 2;
      int[] A = new int[n];// A[i] 表示 10^i 对 k 取模的结果
      A[0] = 1;
      for (int i = 1; i < n; i++) {
        A[i] = A[i - 1] * 10 % k;
      }
      boolean[][] dp = new boolean[m + 1][k];
      dp[m][0] = true;// 此时选择结束，且数的贡献对 k 取模的结果为 0，那么结果就是 true
      for (int i = m - 1; i >= 0; i--) {
        // t 表示 i 位置和 n - i - 1 位置选择 1 时的贡献
        int t = i == m - 1 && (n & 1) != 0 ? A[n - i - 1] : (A[n - i - 1] + A[i]) % k;
        for (int j = 0; j < k; j++) {
          // 此时 i 位置之前选择的数的贡献对 k 取模的结果为 j
          for (int s = 0; s < 9; s++) {// 枚举可选择数
            dp[i][j] |= dp[i + 1][(j + s * t) % k];
          }
        }
      }
      int[] ans = new int[n];
      int i = 0, j = 0;
      o:
      while (i < m) {// 递推获取答案
        int t = i == m - 1 && (n & 1) != 0 ? A[n - i - 1] : (A[n - i - 1] + A[i]) % k;
        for (int s = 9; s >= 0; s--) {// 从大到小遍历，保证选择最大数
          if (dp[i + 1][(j + s * t) % k]) {
            ans[i] = ans[n - i - 1] = s;
            i++;
            j = (j + s * t) % k;
            continue o;
          }
        }
      }
      StringBuilder sb = new StringBuilder();
      for (int v : ans) {
        sb.append(v);
      }
      return sb.toString();
    }
  }
}
