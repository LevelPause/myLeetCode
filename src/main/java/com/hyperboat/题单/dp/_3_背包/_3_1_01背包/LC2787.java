package com.hyperboat.题单.dp._3_背包._3_1_01背包;

/**
 * 2787. 将一个数字表示成幂的和的方案数
 * <p>
 * https://leetcode.cn/problems/ways-to-express-an-integer-as-sum-of-powers/
 */
class LC2787 {

  public int numberOfWays(int n, int x) {
    int mod = (int) 1e9 + 7;
    int[] dp = new int[n + 1];
    int max = (int) Math.pow(n + 1, 1.0 / x);
    int[] pow = new int[max + 1];
    for (int i = 1; i < pow.length; i++) {
      pow[i] = pow(i, x);
    }
    dp[0] = 1;
    for (int i = 1; i < max + 1; i++) {
      for (int j = n; j >= pow[i]; j--) {
        dp[j] = (dp[j] + dp[j - pow[i]]) % mod;
      }
    }
    return dp[n];
  }

  //快速幂
  private int pow(int x, int n) {
    int res = 1;
    while (n > 0) {
      if ((n & 1) == 1) {
        res *= x;
      }
      x *= x;
      n >>= 1;
    }

    return res;
  }


}
