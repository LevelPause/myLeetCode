package com.hyperboat.题单.位运算.试填法;

/*
 * https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/description/
 * */
public class _3007_价值和小于等于K的最大数字 {

  class Solution {

    public long findMaximumNumber(long k, int x) {
      long num = 0;
      long pre1 = 0;
      for (long i = 63 - Long.numberOfLeadingZeros((k + 1) << x); i >= 0; i--) {
        long cnt = (pre1 << i) + (i / x << i >> 1);
        if (cnt > k) {
          continue;
        }
        k -= cnt;
        num |= 1L << i;
        if ((i + 1) % x == 0) {
          pre1++;
        }
      }
      return num - 1;
    }
  }
}
