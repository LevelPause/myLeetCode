package com.hyperboat.题单.位运算.思维题;


import java.util.List;

/**
 * 2897. 对数组执行操作使平方和最大
 * <p>
 * https://leetcode.cn/problems/apply-operations-on-array-to-maximize-sum-of-squares/description/
 */
class LC2897 {

  private static final long MOD = (long) 1e9 + 7;

  public int maxSum(List<Integer> nums, int k) {
    var cnt = new int[30];
    for (var x : nums) {
      var i = 0;
      while (x > 0) {
        cnt[i] += x & 1;
        i++;
        x >>= 1;
      }
    }
    var ans = 0L;
    while (k-- > 0) {
      var x = 0L;
      for (int i = 0; i < cnt.length; i++) {
        if (cnt[i] > 0) {
          cnt[i]--;
          x |= 1 << i;
        }
      }
      ans = (ans + x * x) % MOD;
    }
    return (int) ans;
  }


}
