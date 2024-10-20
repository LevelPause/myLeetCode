package com.hyperboat.题单.dp._1入门dp._1_1爬楼梯;

/**
 * 2266. 统计打字方案数
 * <p>
 * https://leetcode.cn/problems/count-number-of-texts/description/
 */
class LC2266 {

  private final static int MOD = (int) 1e9 + 7;
  private final static int MAX = 100_001;
  private final static long[] dp1 = new long[MAX];
  private final static long[] dp2 = new long[MAX];

  static {

    dp1[0] = dp2[0] = 1;
    dp1[1] = dp2[1] = 1;
    dp1[2] = dp2[2] = 2;
    dp1[3] = dp2[3] = 4;
    for (int i = 4; i < MAX; i++) {
      dp1[i] = (dp1[i - 1] + dp1[i - 2] + dp1[i - 3]) % MOD;
      dp2[i] = (dp2[i - 1] + dp2[i - 2] + dp2[i - 3] + dp2[i - 4]) % MOD;
    }
  }

  public int countTexts(String s) {
    return dp2(s);
  }

  public int dp1(String s) {
    int n = s.length();
    long ans = 1L;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      cnt++;
      if (i == n - 1 || c != s.charAt(i + 1)) {
        ans = ans * (c != '7' && c != '9' ? dp1[cnt] : dp2[cnt]) % MOD;
        cnt = 0;
      }
    }
    return (int) ans;
  }

  public int dp2(String s) {
    final int MOD = (int) 1e9 + 7;
    int n = s.length();
    long[] dp = new long[n];
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      char c = s.charAt(i);
      dp[i] = dp[i - 1];

      if (c == s.charAt(i - 1)) {
        dp[i] += i >= 2 ? dp[i - 2] : 1;
        if (i >= 2 && c == s.charAt(i - 2)) {
          dp[i] += i >= 3 ? dp[i - 3] : 1;
          if (i >= 3 && c == s.charAt(i - 3) && (c == '7' || c == '9')) {
            dp[i] += i >= 4 ? dp[i - 4] : 1;
          }
        }
      }

      dp[i] %= MOD;
    }
    return (int) dp[n - 1];
  }

}
