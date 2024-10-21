package com.hyperboat.题单.位运算.其他;

/**
 * 1680. 连接连续二进制数字
 * <p>
 * https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/description/
 */
class LC1680 {

  private static final int MOD = (int) 1e9 + 7;

  public int concatenatedBinary(int n) {
    var ans = 0L;
    var shift = 0;
    for (int i = 1; i <= n; i++) {
      if ((i & (i - 1)) == 0) {
        shift++;
      }
      ans = (ans << shift | i) % MOD;
    }
    return (int) ans;
  }

}
