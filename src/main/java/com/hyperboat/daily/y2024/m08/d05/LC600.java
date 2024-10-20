package com.hyperboat.daily.y2024.m08.d05;

/*
 * https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/
 * */
class LC600 {

  static int[] dp = new int[32];

  static {
    dp[0] = dp[1] = 1;
    for (int i = 2; i < 32; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
  }

  public int findIntegers(int n) {
    int size = Integer.SIZE- Integer.numberOfLeadingZeros(n);
    int pre = 0;
    int res = 0;
    for (int i = size; i >= 0; i--) {
      int val = 1 << i;
      if ((n & val) != 0) {
        res += dp[i + 1];
        if (pre == 1) {
          break;
        }
        pre = 1;
      } else {
        pre = 0;
      }
      if (i == 0) {
        res++;
      }
    }
    return res;
  }
}
